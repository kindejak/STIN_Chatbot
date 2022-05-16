package com.kindejak.javalinapp.response;


import com.kindejak.javalinapp.utils.RateGetter;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExchangeResponse extends BaseResponse{
    public ExchangeResponse(String bot_id, String language) {
        super(bot_id, language);
    }

    @Override
    public void setNewMessage(String responseKey, String message){
        Locale locale = new Locale(language);
        ResourceBundle languageBundle = ResourceBundle.getBundle("com.kindejak.javalinapp.language.LanguageResource", locale);

        String dateString = parseDateLikeString(message);
        if(dateString == null) {
            this.message = languageBundle.getString("ExchangeDateUnknown");
            return;
        }

        LocalDate localDate = parseDate(dateString);
        if (localDate == null){
            this.message = languageBundle.getString("Exchange").replace("$rate",getRate(LocalDate.now()));
            return;
        }

        if(localDate.isAfter(LocalDate.of(1999,1,1)) && localDate.isBefore(LocalDate.now().plusDays(1))){
            this.message = languageBundle.getString("ExchangeDate").replace("$rate",getRate(localDate)).replace("$date",localDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                return;
            }
        this.message = languageBundle.getString("ExchangeDateUnknown");
    }

    private String parseDateLikeString(String message){
        Pattern pattern = Pattern.compile("(\\b\\d{1,2}(\\.|-|/)\\d{1,2}(\\.|-|/)\\d{4}\\b)");
        Matcher matcher = pattern.matcher(message);
        if(matcher.find()){
            return matcher.group(1);
        }
        return "";
    }

    private String getRate(LocalDate localDate) {
        return RateGetter.getRate(localDate);
    }


    private LocalDate parseDate(String dateString){
        DateTimeFormatter dtf = DateTimeFormatter
                .ofPattern("[dd/MM/yyyy][dd.MM.yyyy][dd-MM-yyyy][d/M/yyyy][d.M.yyyy][d-M-yyyy]");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(dateString, dtf);
        } catch (DateTimeParseException e){
            return null;
        }
        return localDate;
    }
}
