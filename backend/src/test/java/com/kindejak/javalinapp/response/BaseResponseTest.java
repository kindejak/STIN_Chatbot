package com.kindejak.javalinapp.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class BaseResponseTest {

    private BaseResponse baseResponseUnderTest;

    @BeforeEach
    void setUp() {
        baseResponseUnderTest = new BaseResponse("1", "en");
    }

    @Test
    void testSetNewMessage() {
        // Setup
        // Run the test

        baseResponseUnderTest.setNewMessage("Help");
        assertEquals("BaseResponse(bot_id=1, language=en, message=Here is what I can do: <br>-help - I tell you, what I can do <br>-time - I tel you, what time is it, at least at my place.<br>-exchange rate - I tell you an exchange rate between EUR and CZK <br>-name - I tell you my name, image=)",
                    baseResponseUnderTest.toString());

        // Verify the results
    }
}
