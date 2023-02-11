package com.techelevator.application;

import com.techelevator.models.AuditText;
import com.techelevator.models.Balance;
import com.techelevator.models.ItemsForSale;
import com.techelevator.models.TransferFileToList;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

public class VendingMachine {
    private List<ItemsForSale> lisOfItems;

    public void run() {
        UserOutput userOutput = new UserOutput();
        UserInput userInput = new UserInput();
        Balance balance = new Balance(BigDecimal.ZERO);

        String choice;
        BigDecimal money = new BigDecimal(BigInteger.ZERO);
        String slotChosen;

        TransferFileToList list = new TransferFileToList();
        lisOfItems  = list.readItems();
        Balance moneyInMachine = new Balance(money);
        do {
            userOutput.displayHomeScreen();
            choice = userInput.getHomeScreenOption();
            if(choice.equals("display")) {
                callMenu(lisOfItems);
            }
            else if(choice.equals("purchase")) {
                int count = 0;
                int temp = 0;
                BigDecimal tempMoney = new BigDecimal(BigInteger.ZERO);
                while(true) {
                    userOutput.displayPurchaseScreen();
                    choice = userInput.getPurchaseHomeOption(money);
                    if (choice.equals("Feed money")) {
                        money = balance.addMoney();
                        moneyInMachine.setCurrentMoney(money);
                        //depositMoney.deposit();
                    } else if (choice.equals("Select item")) {
                        boolean slotExist = false;
                        boolean itemAvailable = false;
                        ItemsForSale test = new ItemsForSale("", "", BigDecimal.ZERO, "");
                        callMenu(lisOfItems);
                        slotChosen = UserInput.getSlotIdentifier();
                        for (ItemsForSale item : lisOfItems) {
                            if(slotChosen.equals(item.getSlot())) {
                                slotExist = true;
                                test = item;
                            }
                        }
                        if(slotExist) {
                            int quantityTest = test.getInStock();
                            if(quantityTest > 0) {
                                itemAvailable = true;
                            }
                        }
                        else { //slot exists checking availability
                            System.out.println("Slot identifier does not exist.");
                        }
                        if(!itemAvailable && slotExist) {
                            System.out.println("Item is out of stock.");
                        }
                        if(itemAvailable && money.compareTo(BigDecimal.ZERO) > 0) {
                            count++;
                            boolean thanksgiving = false;
                            if(count % 2 == 0) {
                                System.out.println("Discount: one dollar off");
                                thanksgiving = true;
                            }
                            //METHODS
                            tempMoney = money;
                            BigDecimal remainingBalance = new BigDecimal(BigInteger.ZERO);
                            money = updateBalance(test, money);
                            if(tempMoney.compareTo(money) == 1) {
                                moneyInMachine.setCurrentMoney(money);
                                temp = dispensing(test, money, thanksgiving, tempMoney);
                                test.setInStock(temp);
                            }
                            else {
                                System.out.println("Not enough money.");
                            }
                        }
                        else {
                            if(money.equals(BigDecimal.ZERO)) {
                                System.out.println("Current balance is zero");
                            }
                        }
                    } else if (choice.equals("Finish transaction")) {
                        System.out.println("Your change is: " + moneyInMachine.getCurrentMoney());
                        change(moneyInMachine.getCurrentMoney());
                        moneyInMachine.setCurrentMoney(BigDecimal.ZERO);
                        break;
                    }
                }
            }
            else if (choice.equals("exit")) {
                break;
            }
        } while(true);
    }


    public BigDecimal updateBalance(ItemsForSale item, BigDecimal balance) {
        if(balance.compareTo(item.getPrice()) != -1) {
            balance = balance.subtract(item.getPrice());
            return balance;
        }
        return balance;
    }

    public int dispensing(ItemsForSale item, BigDecimal remainingBalance, boolean tg, BigDecimal tempMoney) {
        BigDecimal tempBalance = new BigDecimal(String.valueOf(remainingBalance));
        BigDecimal tempPrice = item.getPrice();
            if(tg) {
                tempPrice = tempPrice.subtract(BigDecimal.ONE);
            }
            System.out.println(item.getItemName() + " $" + tempPrice + " Remaining Balance: $" + remainingBalance);
            System.out.println(item.getSound());
            int remaining = item.getInStock() - 1;
            AuditText stuff = new AuditText(item.getItemName(), item.getSlot(), tempMoney, tempBalance);
            stuff.getAuditText();
            return remaining;
    }

    public void change(BigDecimal change) {
        AuditText stuff = new AuditText("CHANGE GIVEN: ", "  ", change, new BigDecimal("0.00"));
        stuff.getAuditText();
        BigDecimal dollars = new BigDecimal("1");
        BigDecimal quarters = new BigDecimal("0.25");
        BigDecimal dimes = new BigDecimal("0.10");
        BigDecimal nickels = new BigDecimal("0.05");

        BigDecimal[] amount = new BigDecimal[4];
        BigDecimal[] values = new BigDecimal[] {dollars, quarters, dimes, nickels};
        for(int i = 0; i < amount.length; i++) {
            amount[i] = change.divide(values[i], 0, RoundingMode.DOWN);
            change = change.setScale(2).remainder(values[i]);
        }
        System.out.println("Dollars: " + amount[0] + " | Quarters: " + amount[1] + " | Dimes: " + amount[2] + " | Nickels: " + amount[3]);
    }

    public void callMenu(List<ItemsForSale> list1) {
        System.out.println();
        int name = list1.get(0).getItemName().length();
        for(int i = 0; i < list1.size(); i++) {
            int temp = list1.get(i).getItemName().length();
            if(temp > name) {
                name = temp + 3;
            }
        }
        for (ItemsForSale item : list1) {
            System.out.println(String.format("%-4s", item.getSlot()) + String.format("%-" + String.valueOf(name) + "s", item.getItemName()) + String.format("%-8s", "$" + item.getPrice()) + String.format("%-20s", "Quantity Left: " + String.valueOf(item.getInStock())));
        }
        System.out.println();
    }
}
