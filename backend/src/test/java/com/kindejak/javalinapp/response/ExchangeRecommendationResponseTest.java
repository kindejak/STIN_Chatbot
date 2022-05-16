package com.kindejak.javalinapp.response;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;


class ExchangeRecommendationResponseTest {

    private ExchangeRecommendationResponse exchangeRecommendationResponseUnderTest;

    @BeforeEach
    void set_up() {
        exchangeRecommendationResponseUnderTest = new ExchangeRecommendationResponse("1", "en");
    }

    @Test
    void test_set_new_message() {
        // Setup
        // Run the test
        exchangeRecommendationResponseUnderTest.setNewMessage("recommendation", "recommendation exchanging euro");
        Assertions.assertTrue(exchangeRecommendationResponseUnderTest.toString().contains("(my threshold is set to 10%)"));
        // Verify the results
    }

    @Test
    void test_get_recommendation() {
        Assertions.assertEquals("In my honest opinion it's great time to exchange money, because between 13.05.2022 and 16.05.2022 exchange rate changed by -0.12% (my threshold is set to 10%)",
                exchangeRecommendationResponseUnderTest.getRecommendationBetweenDates(LocalDate.of(2022,5,13),LocalDate.of(2022,5,16)));
    }

    @Test
    void test_get_another_recommendation() {
        Assertions.assertEquals("Sorry I think you shouldn't exchange money because between 13.02.2020 and 03.04.2020 exchange rate changed by 10.89% (my threshold is set to 10%)",
                exchangeRecommendationResponseUnderTest.getRecommendationBetweenDates(LocalDate.of(2020,2,13),LocalDate.of(2020,4,3)));
    }
}
