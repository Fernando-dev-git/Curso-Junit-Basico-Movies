package org.example.discounts;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PriceCalculatorTest {

    private PriceCalculator priceCalculator;

    @Before
    public void setup(){
        priceCalculator = new PriceCalculator();
    }

    @Test
    public void total_zero_when_there_are_prices(){
        assertThat(priceCalculator.getTotal(), is(0.0));
    }

    @Test
    public void total_is_the_sum_of_prices(){
        priceCalculator.addPrice(100.0);
        priceCalculator.addPrice(50.0);
        assertThat(priceCalculator.getTotal(),  is(150.0));
    }

    @Test
    public void apply_discount_to_price(){
        priceCalculator.addPrice(100.0);
        priceCalculator.addPrice(50.0);
        priceCalculator.addPrice(50.0);

        priceCalculator.setDiscount(25.0);
        assertThat(priceCalculator.getTotal(), is(150.0));
    }

}