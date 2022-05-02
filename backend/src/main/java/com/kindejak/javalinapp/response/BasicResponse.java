package com.kindejak.javalinapp.response;

import lombok.Getter;

import java.util.Locale;
import java.util.ResourceBundle;

public class BasicResponse {
    @Getter
    private String bot_id; //wrong naming convention due to required output to json object
    @Getter
    private String language;
    @Getter
    private String message;

    public BasicResponse(String bot_id, String language, String responseKey) {
        this.bot_id = bot_id;
        this.language = language;
        Locale locale = new Locale(language);
        ResourceBundle languageBundle = ResourceBundle.getBundle("com.kindejak.javalinapp.language.LanguageResource", locale);
        this.message = languageBundle.getString(responseKey);
    }
}
