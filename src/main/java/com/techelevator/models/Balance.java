package com.techelevator.models;

import java.math.BigDecimal;
import java.util.Scanner;


public class Balance {
    private BigDecimal currentMoney;


    public Balance(BigDecimal x) {
        this.currentMoney = x;
        this.currentMoney = this.currentMoney.setScale(2);

    }

    public BigDecimal getCurrentMoney() { //return balance of money fed to machine
        return currentMoney;
    }

    public void setCurrentMoney(BigDecimal money) {
        this.currentMoney = money;
        this.currentMoney = this.currentMoney.setScale(2);

    }
    public BigDecimal addMoney() {
        Scanner feedMoney = new Scanner(System.in);
        BigDecimal one = new BigDecimal(1);
        BigDecimal five = new BigDecimal(5);
        BigDecimal ten = new BigDecimal(10);
        BigDecimal twenty = new BigDecimal(20);

            while (true) {
                System.out.println("Please enter money (only $1, $5, $10 or $20 bills): ");
                System.out.println("When done entering money please type 'done'");
                String userInput = feedMoney.nextLine();
                if (userInput.equals("done")) {
                    break;
                }
                BigDecimal money = new BigDecimal(userInput);
                if (money.compareTo(one) == 0 || money.compareTo(five) == 0 || money.compareTo(ten) == 0 || money.compareTo(twenty) == 0) {
                    currentMoney = currentMoney.add(money);
                    money = money.setScale(2);
                    AuditText stuff = new AuditText("MONEY FED: ", "  ", money, currentMoney);
                    stuff.getAuditText();
                } else {
                    System.out.println("Error, incorrect bill amount");
                }
                System.out.println("Current balance: " + "$" + currentMoney);
            }
            return currentMoney;
    }
}
