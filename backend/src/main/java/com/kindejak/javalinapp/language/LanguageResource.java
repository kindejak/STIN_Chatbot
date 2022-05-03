package com.kindejak.javalinapp.language;

import java.util.ListResourceBundle;

public class LanguageResource extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                //responses
                {"Unrecognised","I don't know what you're talking about."}
        };
    }
}


