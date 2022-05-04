package com.kindejak.javalinapp.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TimeResponseTest {

    private TimeResponse timeResponseUnderTest;

    @BeforeEach
    void setUp() {
        timeResponseUnderTest = new TimeResponse("1", "en");
    }

    @ParameterizedTest
    @CsvSource({"Time, what time is it?",
            "Time, time!",
            "Time, do you know what time is it?"})
    void testSetNewMessage(String exchange, String message) {
        // Setup
        // Run the test
        timeResponseUnderTest.setNewMessage(exchange, message);
        Assertions.assertTrue(timeResponseUnderTest.getMessage().contains(", at least at my place."));
        // Verify the results
    }
}
