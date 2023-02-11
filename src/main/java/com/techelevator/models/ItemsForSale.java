package com.techelevator.models;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ItemsForSale {
    private String slot;
    private String itemName;
    private BigDecimal price;
    private String type;
    private int inStock;

    public ItemsForSale(String slot1, String itemName, BigDecimal price, String type) {
        this.slot = slot1;
        this.itemName = itemName;
        this.price = price;
        this.type = type;
        this.inStock = 6;
    }

    public String getSlot() {

        return slot;
    }
    public String getItemName(){

        return itemName;
    }
    public BigDecimal getPrice() {

        return price;
    }
    public String getType() {

        return type;
    }

    public int getInStock() {

        return inStock;
    }
    public void setInStock(int inStock) {

        this.inStock = inStock;
    }

    public String getSound(){

        return "";
    }
}
