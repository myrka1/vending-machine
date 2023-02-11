package com.techelevator.models;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditText {
    private String activity;
    private String slot;
    private BigDecimal deposit;
    private BigDecimal total;

    public AuditText(String activity, String slot, BigDecimal deposit, BigDecimal total) {
        this.activity = activity;
        this.slot = slot;
        this.deposit = deposit;
        this.total = total;
    }
    public void getAuditText() {
        File auditFile = new File("audit.txt");
        if (!auditFile.exists()) {
            try {
                auditFile.createNewFile();
            } catch (IOException e) {
                System.out.println("File not created");
            }
        }
        try (PrintWriter dataOutput = new PrintWriter(new FileOutputStream(auditFile, true))) {
            dataOutput.println(timeDateStuff() + String.format("%-25s", activity) + " " + String.format("%-4s", slot) + String.format("%-10s", "$"+deposit) + String.format("%-10s", "$"+total));
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the file for writing.");
        }
    }
    //time and date stuff
    public String timeDateStuff() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E MM/dd/yyyy hh:mm:ss a");
        String currentDateTime = dateTime.format(dateFormat);
        return (currentDateTime + "      ");
    }
}
