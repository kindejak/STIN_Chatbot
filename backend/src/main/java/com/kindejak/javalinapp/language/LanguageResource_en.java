package com.kindejak.javalinapp.language;

import java.util.ListResourceBundle;

public class LanguageResource_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                //responses
                {"unrecognised_response","I don't know what you talking about."},
                {"name_response","Hi, nice to meet you! My name is"},
                {"time_response","The time is $HH:MM:SS, at least at my place."},
                {"exchange_response","Exchange rate is $rate CZK for 1 EUR"},
                {"exchange-date_response","On $date the exchange rate was $rate CZK for 1 EUR"},
                {"help_response","Here is what I can do: \n-help - I tell you, what I can do \n" +
                        "-time - I tel you, what time is it, at least at my place. " +
                        "\n-exchange rate - I tell you an exchange rate between EUR and CZK \n-name - I tell you my name"}
        };
    }
}
