package com.kindejak.javalinapp.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class NameResponseTest {

    private NameResponse nameResponseUnderTest;

    @BeforeEach
    void setUp() {
        nameResponseUnderTest = new NameResponse("1", "en");;
    }

    @Test
    void test_set_new_message() {
        // Setup
        // Run the test
        nameResponseUnderTest.setNewMessage("Name","name");
        Assertions.assertEquals("Hi, nice to meet you! My name is SuperBot.",nameResponseUnderTest.getMessage());
        // Verify the results
    }

    @Test
    void test_get_string(){
        Assertions.assertEquals("BaseResponse(bot_id=1, language=en, message=, image=)",nameResponseUnderTest.toString());
    }
}
