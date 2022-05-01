package com.kindejak.javalinapp.language;

import lombok.Getter;

import java.util.ArrayList;

public class LanguageKeyword {
    @Getter private String name;
    @Getter private ArrayList<String> keywords;

    public LanguageKeyword(String name, ArrayList<String> keywords) {
        this.name = name;
        this.keywords = keywords;
    }
}
