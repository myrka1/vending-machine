package com.techelevator.models;

import java.math.BigDecimal;

public class CandyClass extends ItemsForSale {

    public CandyClass(String slot1, String itemName, BigDecimal price) {

        super(slot1, itemName, price, "Candy");
    }

    @Override
    public String getSound() {
        return "Sugar, Sugar, so Sweet!";
    }
}
