package com.kindejak.javalinapp.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class NameResponseTest {

    private NameResponse nameResponseUnderTest;

    @BeforeEach
    void setUp() {
        nameResponseUnderTest = new NameResponse("1", "en");;
    }

    @Test
    void testSetNewMessage() {
        // Setup
        // Run the test
        nameResponseUnderTest.setNewMessage("Name","name");
        assertEquals("Hi, nice to meet you! My name is SuperBot.",nameResponseUnderTest.getMessage());
        // Verify the results
    }
}
