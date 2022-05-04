package com.kindejak.javalinapp.response;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;

public class TimeResponse extends BaseResponse{
    public TimeResponse(String bot_id, String language) {
        super(bot_id, language);
    }

    @Override
    public void setNewMessage(String responseKey, String message){
        Locale locale = new Locale(language);
        ResourceBundle languageBundle = ResourceBundle.getBundle("com.kindejak.javalinapp.language.LanguageResource", locale);
        String timeString = LocalTime.now().
                format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.message = languageBundle.getString(responseKey).replace("$HH:MM:SS",timeString);
    }
}
