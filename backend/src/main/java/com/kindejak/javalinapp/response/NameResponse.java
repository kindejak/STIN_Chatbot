package com.kindejak.javalinapp.response;

import java.util.Locale;
import java.util.ResourceBundle;

public class NameResponse extends BaseResponse {

    public NameResponse(String bot_id, String language) {
        super(bot_id, language);
    }

    @Override
    public void setNewMessage(String responseKey, String message){
        Locale locale = new Locale(language);
        ResourceBundle languageBundle = ResourceBundle.getBundle("com.kindejak.javalinapp.language.LanguageResource", locale);
        this.message = languageBundle.getString(responseKey) + " SuperBot.";
        this.image = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/7d5ddb7c-de98-44f4-8784-1cabe975846f/dbhpz61-c1148580-118b-4eff-bced-123d8c47adb7.png/v1/fill/w_400,h_400,strp/commission__bot_avatar_by_eyes11_dbhpz61-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzdkNWRkYjdjLWRlOTgtNDRmNC04Nzg0LTFjYWJlOTc1ODQ2ZlwvZGJocHo2MS1jMTE0ODU4MC0xMThiLTRlZmYtYmNlZC0xMjNkOGM0N2FkYjcucG5nIiwiaGVpZ2h0IjoiPD00MDAiLCJ3aWR0aCI6Ijw9NDAwIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLndhdGVybWFyayJdLCJ3bWsiOnsicGF0aCI6Ilwvd21cLzdkNWRkYjdjLWRlOTgtNDRmNC04Nzg0LTFjYWJlOTc1ODQ2ZlwvZXllczExLTQucG5nIiwib3BhY2l0eSI6OTUsInByb3BvcnRpb25zIjowLjQ1LCJncmF2aXR5IjoiY2VudGVyIn19.LGfYFb6fWTV7PCTytj-XvesDbIdbHa8n6BAkhLwEafE";
    }
}
