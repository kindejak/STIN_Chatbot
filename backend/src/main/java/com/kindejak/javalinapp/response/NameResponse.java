package com.kindejak.javalinapp.response;

import java.util.Locale;
import java.util.ResourceBundle;

public class NameResponse extends BaseResponse {

    public NameResponse(String bot_id, String language) {
        super(bot_id, language);
    }

    @Override
    public void setNewMessage(String responseKey){
        Locale locale = new Locale(language);
        ResourceBundle languageBundle = ResourceBundle.getBundle("com.kindejak.javalinapp.language.LanguageResource", locale);
        this.message = languageBundle.getString(responseKey) + " SuperBot.";
    }
}
