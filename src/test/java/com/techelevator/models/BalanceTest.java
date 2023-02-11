package com.techelevator.models;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class BalanceTest {

    @Test
    public void getCurrentMoney() {
        Balance testGet = new Balance(new BigDecimal("45"));
        BigDecimal result = new BigDecimal(String.valueOf(testGet.getCurrentMoney()));
        Assert.assertEquals(new BigDecimal("45.00"), result);
    }

    @Test
    public void setCurrentMoney() {
        Balance testSet = new Balance(new BigDecimal("50"));
        testSet.setCurrentMoney(new BigDecimal("23")); //23.00
        BigDecimal result = new BigDecimal(String.valueOf(testSet.getCurrentMoney()));
        Assert.assertEquals(new BigDecimal("23.00"), result);
    }

    @Test
    public void addMoney() {
        /*
        Scanner feedMoney = new Scanner(System.in);
        Balance testAddMoney = new Balance(new BigDecimal("0"));
        String userInput = feedMoney.nextLine();
        userInput = "20";
        BigDecimal money = new BigDecimal(userInput);

        Assert.assertEquals(new BigDecimal("20.00"), money);

         */
    }
}