package com.kindejak.javalinapp.language;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LanguageKeywordTest {

    private LanguageKeyword languageKeywordUnderTest;

    @BeforeEach
    void setUp() {
        languageKeywordUnderTest = new LanguageKeyword();
        languageKeywordUnderTest.setName("Undefined");
        ArrayList<String> al = new ArrayList<String>();
        al.add("nothing");
        languageKeywordUnderTest.setKeywords(al);
    }

    @Test
    void testToString() {
        assertEquals("LanguageKeyword(name=Undefined, keywords=[nothing])", languageKeywordUnderTest.toString());
    }
}
