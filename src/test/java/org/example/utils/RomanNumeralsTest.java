package org.example.utils;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanNumeralsTest {

    private RomanNumerals romanNumerals;

    @Before
    public void setup(){
        romanNumerals = new RomanNumerals();
    }

    @Test
    public void number_from_1_to_10(){
        assertThat(romanNumerals.arabicToRoman(1), is("I"));
        assertThat(romanNumerals.arabicToRoman(19), is("XIX"));
    }

}