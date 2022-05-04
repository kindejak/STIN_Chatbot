package com.kindejak.javalinapp.language;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

class LanguageResourceTest {


   /*
    @Test
    void testUnknownLanguage() {
        // Setup
        // Run the test
        ResourceBundle languageBundle = ResourceBundle.getBundle("com.kindejak.javalinapp.language.LanguageResource", new Locale("cs"));
        assertEquals(1,Collections.list(languageBundle.getKeys()).size());

        // Verify the results
    }
    */

    @Test
    void testKnownLanguage() {
        // Setup
        // Run the test
        ResourceBundle languageBundle = ResourceBundle.getBundle("com.kindejak.javalinapp.language.LanguageResource", new Locale("en"));
        assertEquals(6,Collections.list(languageBundle.getKeys()).size());

        // Verify the results
    }
}
