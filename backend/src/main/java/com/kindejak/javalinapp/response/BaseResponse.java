package com.kindejak.javalinapp.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Locale;
import java.util.ResourceBundle;

@ToString
public class BaseResponse extends Response {
    @Getter @Setter
    protected String bot_id; //wrong naming convention due to required output to json object
    @Getter @Setter
    protected String language;
    @Getter @Setter
    protected String message;
    @Getter @Setter
    protected String image = "";

    public BaseResponse(String bot_id, String language) {
        this.bot_id = bot_id;
        this.language = language;
    }

    public void setNewMessage(String responseKey) {
        Locale locale = new Locale(language);
        ResourceBundle languageBundle = ResourceBundle.getBundle("com.kindejak.javalinapp.language.LanguageResource", locale);
        this.message = languageBundle.getString(responseKey);
    }
}
