package com.techelevator.models;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class TransferFileToMapTest {

    @Test
    public void readItems() {
        TransferFileToList test = new TransferFileToList();
        List<ItemsForSale> collectItems = test.readItems();
        ItemsForSale items = null;
        for (ItemsForSale item : collectItems){
            if (item.getSlot().equals("A1")) {
                items = item;
            }
        }
        BigDecimal test1 = new BigDecimal(String.valueOf(BigDecimal.ZERO));

        Assert.assertEquals("U-Chews", items.getItemName());
        Assert.assertEquals(new BigDecimal("1.65"), items.getPrice());
        Assert.assertEquals( "A1", items.getSlot());
        Assert.assertEquals( "Gum", items.getType());
        Assert.assertEquals(16, collectItems.size());
    }
}
