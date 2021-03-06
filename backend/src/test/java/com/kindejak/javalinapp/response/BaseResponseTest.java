package com.kindejak.javalinapp.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BaseResponseTest {

    private BaseResponse baseResponseUnderTest;

    @BeforeEach
    void set_up() {
        baseResponseUnderTest = new BaseResponse("1", "en");
    }

    @Test
    void test_set_new_message() {
        // Setup
        // Run the test

        baseResponseUnderTest.setNewMessage("Help","help");
        Assertions.assertEquals("BaseResponse(bot_id=1, language=en, message=Here is what I can do: <br>-help - I tell you, what I can do <br>-time - I tel you, what time is it, at least at my place.<br>-exchange rate - I tell you an exchange rate between EUR and CZK <br>-name - I tell you my name, image=)",
                    baseResponseUnderTest.toString());

        // Verify the results
    }

    @Test
    void test_get_string(){
        Assertions.assertEquals("BaseResponse(bot_id=1, language=en, message=, image=)",baseResponseUnderTest.toString());
    }
}
