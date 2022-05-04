package com.kindejak.javalinapp.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileGetterTest {

    private FileGetter fileGetterUnderTest;

    @BeforeEach
    void setUp() {
        fileGetterUnderTest = new FileGetter();
    }

    @Test
    void testGetFileFromResourceAsStream() {
        // Setup
        // Run the test
        final InputStream result = fileGetterUnderTest.getFileFromResourceAsStream("language/Map_en.json");
        assertNotNull(result);

        // Verify the results
    }
}
