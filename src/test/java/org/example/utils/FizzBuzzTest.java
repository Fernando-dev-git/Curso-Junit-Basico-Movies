package org.example.utils;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setup(){
       fizzBuzz = new FizzBuzz();
    }

    @Test
    public void when_the_number_is_divisible_by_three(){
        assertThat(fizzBuzz.makeMessage(3), is("Fizz"));
        assertThat(fizzBuzz.makeMessage(6), is("Fizz"));
    }

    @Test
    public void when_the_number_is_divisible_by_five(){
        assertThat(fizzBuzz.makeMessage(10), is("Buzz"));
        assertThat(fizzBuzz.makeMessage(5), is("Buzz"));
    }

    @Test
    public void when_the_number_is_divisible_by_three_and_five(){
        assertThat(fizzBuzz.makeMessage(15), is("FizzBuzz"));
        assertThat(fizzBuzz.makeMessage(30), is("FizzBuzz"));
    }

    @Test
    public void when_the_number_is_not_divisible(){
        assertThat(fizzBuzz.makeMessage(16), is("16"));
        assertThat(fizzBuzz.makeMessage(2), is("2"));
    }

}