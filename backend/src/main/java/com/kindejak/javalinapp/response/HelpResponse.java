package com.kindejak.javalinapp.response;

import java.util.Locale;
import java.util.ResourceBundle;

public class HelpResponse {
    private String bot_id; //wrong naming convention due to required output to json object
    private String language;
    private String message;

    public HelpResponse(String bot_id, String language, String responseKey) {
        this.bot_id = bot_id;
        this.language = language;
        ResourceBundle languageBundle = ResourceBundle.
                getBundle("com.kindejak.javalinapp.language", new Locale(language));
        this.message = languageBundle.getString(responseKey);
    }
}
