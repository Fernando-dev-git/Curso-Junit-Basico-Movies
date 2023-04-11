package org.example.utils;

import org.junit.Test;

import static org.example.utils.PasswordUtils.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilsTest {

    @Test
    public void weak_when_has_less_that_8_letters() {
        assertEquals(WEAK, PasswordUtils.assesPassword("123456"));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(WEAK, PasswordUtils.assesPassword("Maverick"));
    }

    @Test
    public void medium_when_has_letters_and_number(){
        assertEquals(MEDIUM, PasswordUtils.assesPassword("abcDsa123"));
    }

    @Test
    public void medium_when_has_letters_number_and_symbols(){
        assertEquals(STRONG, PasswordUtils.assesPassword("abcDsa123$"));
    }


}