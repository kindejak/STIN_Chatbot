package com.kindejak.javalinapp.language;

import java.util.ListResourceBundle;

public class LanguageResource_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                //responses
                {"Unrecognised","I don't know what you're talking about."},
                {"Name","Hi, nice to meet you! My name is"},
                {"Time","The time is $HH:MM:SS, at least at my place."},
                {"Exchange","Exchange rate is $rate CZK for 1 EUR"},
                {"ExchangeDate","On $date the exchange rate was $rate CZK for 1 EUR"},
                {"ExchangeDateUnknown","I don't know exchange rate for this date"},
                {"ExchangeRecommendationPositive","In my honest opinion it's great time to exchange money, because between $date1 and $date2 exchange rate changed by $change% (my threshold is set to 10%)"},
                {"ExchangeRecommendationNegative","Sorry I think you shouldn't exchange money because between $date1 and $date2 exchange rate changed by $change% (my threshold is set to 10%)"},
                {"Help","Here is what I can do: <br>-help - I tell you, what I can do <br>-time - I tel you, what time is it, at least at my place.<br>-exchange rate - I tell you an exchange rate between EUR and CZK <br>-name - I tell you my name"}
        };
    }
}
