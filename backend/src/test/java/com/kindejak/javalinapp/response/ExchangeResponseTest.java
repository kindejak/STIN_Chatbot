package com.kindejak.javalinapp.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ExchangeResponseTest {

    private ExchangeResponse exchangeResponseUnderTest;

    @BeforeEach
    void set_up() {
        exchangeResponseUnderTest = new ExchangeResponse("1", "en");
    }

    @ParameterizedTest
    @CsvSource({"Exchange, euro to czk",
                "Exchange, I want to exchange.",
                "Exchange, exchange rate!"})
    void test_get_current_date(String exchange, String message) {
        // Setup
        // Run the test
        exchangeResponseUnderTest.setNewMessage(exchange, message);
        Assertions.assertTrue(exchangeResponseUnderTest.getMessage().contains("Exchange rate is"));
        // Verify the results
    }

    @ParameterizedTest
    @CsvSource({"Exchange, euro to czk on 01.01.2010",
            "Exchange, If I wanted to exchange on 1/1/2010.",
            "Exchange, 1-1-2010 exchange rate!"})
    void test_get_specific_date_format_1_2_2010(String exchange, String message){
        exchangeResponseUnderTest.setNewMessage(exchange, message);
        Assertions.assertEquals("On 01.01.2010 the exchange rate was 26,465 CZK for 1 EUR",exchangeResponseUnderTest.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"Exchange, euro to czk on 01/01/0001",
            "Exchange, If I wanted to exchange on 1/1/1900.",
            "Exchange, exchange rate on 2.2.2200"})
    void test_get_specific_date_invalid_format(String exchange, String message){
        exchangeResponseUnderTest.setNewMessage(exchange, message);
        Assertions.assertEquals("I don't know exchange rate for this date",exchangeResponseUnderTest.getMessage());
    }

    @Test
    void test_get_string(){
        Assertions.assertEquals("BaseResponse(bot_id=1, language=en, message=, image=)",exchangeResponseUnderTest.toString());
    }
}
