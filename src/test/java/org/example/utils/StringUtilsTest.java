package org.example.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void RepeatTest(){
        assertEquals(StringUtils.repeat("Hola", 3), "HolaHolaHola");
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times(){
        StringUtils.repeat("zero", -1);
    }

    @Test
    public void word_is_not_empty(){
        assertFalse(StringUtils.isEmpty("Maverick"));
    }

    @Test
    public void quotation_marks_is_empty(){
        assertTrue(StringUtils.isEmpty(""));
    }

    @Test
    public void space_is_empty(){
        assertTrue(StringUtils.isEmpty(" "));
    }

    @Test
    public void null_is_empty(){
        assertTrue(StringUtils.isEmpty(null));
    }


}