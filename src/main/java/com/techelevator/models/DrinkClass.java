package com.techelevator.models;

import java.math.BigDecimal;

public class DrinkClass extends ItemsForSale{
    public DrinkClass(String slot1, String itemName, BigDecimal price) {
        super(slot1, itemName, price, "Drink");
    }

    @Override
    public String getSound() {
        return "Drinky, Drinky, Slurp Slurp!";
    }
}
