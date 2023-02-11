package com.techelevator.models;

import java.math.BigDecimal;

public class GumClass extends ItemsForSale{
    public GumClass(String slot1, String itemName, BigDecimal price) {
        super(slot1, itemName, price,"Gum");
    }

    @Override
    public String getSound() {
        return "Chewy, Chewy, Lots O Bubbles!";
    }
}
