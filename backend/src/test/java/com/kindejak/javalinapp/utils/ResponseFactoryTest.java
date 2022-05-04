package com.kindejak.javalinapp.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kindejak.javalinapp.request.BasicRequest;
import com.kindejak.javalinapp.response.BaseResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.Assert.assertEquals;

class ResponseFactoryTest {

    private ResponseFactory responseFactoryUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        responseFactoryUnderTest = new ResponseFactory("en");
    }

    @Test
    void testGetResponse() throws Exception {
        // Setup
        final BasicRequest request = new BasicRequest();
        request.setBot_id("1");
        request.setLanguage("en");
        request.setMessage("Your name");

        // Run the test
        final BaseResponse result = (BaseResponse) responseFactoryUnderTest.getResponse(request);
        assertEquals("Hi, nice to meet you! My name is SuperBot.",result.getMessage());
        // Verify the results
    }


}
