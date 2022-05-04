package com.kindejak.javalinapp.language;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@NoArgsConstructor
@ToString
public class LanguageKeyword {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private ArrayList<String> keywords;

}
