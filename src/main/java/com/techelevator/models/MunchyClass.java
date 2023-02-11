package com.techelevator.models;

import java.math.BigDecimal;

public class MunchyClass extends ItemsForSale{


    public MunchyClass(String slot1, String itemName, BigDecimal price) {
        super(slot1, itemName, price,"Munchy");
    }

    @Override
    public String getSound() {
        return "Munchy, Munchy, so Good!";
    }
}
