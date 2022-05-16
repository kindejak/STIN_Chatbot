package com.kindejak.javalinapp.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class RateGetterTest {

    @Test
    void test_rate_getter() {
        String rate = RateGetter.getRate((LocalDate.of(2020,2,13)));
        Assertions.assertEquals("24,835",rate);
    }
}
