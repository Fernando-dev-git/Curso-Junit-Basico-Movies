package org.example.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

    private Double discount;
    private List<Double> prices;

    public PriceCalculator(){
        discount = 0.0;
        prices = new ArrayList<>();
    }

    public Double getTotal() {
        double total = 0;
        for(Double price : prices){
            total += price;
        }
        return total * ((100-discount) / 100);
    }

    public void addPrice(Double precio) {
        prices.add(precio);
    }

    public void setDiscount(Double discount){
        this.discount = discount;
    }
}
