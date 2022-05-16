package com.kindejak.javalinapp.response;

import com.kindejak.javalinapp.utils.RateGetter;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class ExchangeRecommendationResponse extends BaseResponse{
    private final double THRESHOLD = 0.1;

    public ExchangeRecommendationResponse(String bot_id, String language) {
        super(bot_id, language);
    }

    @Override
    public void setNewMessage(String responseKey, String message) {
        LocalDate date2 = getWorkday(LocalDate.now());
        LocalDate date1 = getWorkday(date2.minusDays(3));
        this.message = getRecommendationBetweenDates(date1, date2);
    }

    public String getRecommendationBetweenDates(LocalDate date1, LocalDate date2){
        Locale locale = new Locale(language);
        ResourceBundle languageBundle = ResourceBundle.getBundle("com.kindejak.javalinapp.language.LanguageResource", locale);
        double change = changeRateBetweenDates(date1,date2);
        String recommendation = "";
        if(change > THRESHOLD){
            recommendation = languageBundle.getString("ExchangeRecommendationNegative");
        } else {
            recommendation = languageBundle.getString("ExchangeRecommendationPositive");
        }
        return formatExchangeRecommendationMessage(recommendation,date1,date2,change);
    }

    private String formatExchangeRecommendationMessage(String recommendation, LocalDate date1, LocalDate date2,double change){
        String date1String = date1.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String date2String = date2.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        DecimalFormat df = new DecimalFormat("0.00");
        return recommendation.replace("$date1",date1String)
                .replace("$date2",date2String)
                .replace("$change",df.format(change*100) + "");
    }

    private LocalDate getWorkday(LocalDate date){
        while (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                date.getDayOfWeek() == DayOfWeek.SUNDAY){
            date = date.minusDays(1);
        }
        return date;
    }

    private double changeRateBetweenDates(LocalDate date1, LocalDate date2){
        String date1String = RateGetter.getRate(date1);
        String date2String = RateGetter.getRate(date2);
        double date1Rate;
        double date2Rate;
        if (date1String != null && date2String != null){
            date1String = date1String.replace(",",".");
            date2String = date2String.replace(",",".");
            date1Rate = Double.parseDouble(date1String);
            date2Rate = Double.parseDouble(date2String);
        } else {
            throw new NullPointerException();
        }
        return (date2Rate - date1Rate) / date1Rate;
    }
}
