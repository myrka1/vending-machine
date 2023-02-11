package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private Scanner scanner = new Scanner(System.in);

    public String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D"))
        {
            return "display";
        }
        else if (option.equals("P"))
        {
          return "purchase";
        }
        else if (option.equals("E"))
        {
            return "exit";
        }
        else
        {
            return "";
        }
    }

    public String getPurchaseHomeOption (BigDecimal num){
        System.out.println("M) Feed money");
        System.out.println("S) Select item");
        System.out.println("F) Finish transaction");
        System.out.println();
        System.out.println("Current Money Provided: $" + num); //variable is in method?
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();
        if (option.equals("M")){
            return "Feed money";
        }
        else if(option.equals("S")){
            return "Select item";
        }
        else if (option.equals("F")){
            return "Finish transaction";
        }
        else {
            return "";
        }
    }

    public static String getSlotIdentifier() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Select slot identifier for item: ");
        String selectedOption = scan.nextLine();
        String option = selectedOption.trim().toUpperCase();
        return option;
    }
    
}
