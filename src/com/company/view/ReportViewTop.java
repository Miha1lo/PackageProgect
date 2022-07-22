package com.company.view;

import com.company.dto.BuyingDto;
import com.company.dto.ReportDto;
import com.company.dto.ReportTopDto;

import java.util.Arrays;

public class ReportViewTop {

    public static final String DESCRIPTION = "REPORT TOP DATA: ";

    public void printDetails(ReportTopDto reportTop, int numTop) {
        int dash = 40;
        System.out.println("=".repeat(dash));
        System.out.println(DESCRIPTION + reportTop.getName() + " " + numTop + " product:");
        System.out.println("=".repeat(dash));

        System.out.printf("%-20s %5s %n", "name", "count");
        System.out.println("=".repeat(dash));
        if (numTop <= reportTop.getData().length) {
            for (int i = 0; i < numTop; i++) {
                System.out.printf("%-20s %5s %n", reportTop.getData()[i].getName(), reportTop.getData()[i].getCount());
                System.out.println("-".repeat(dash));
            }
        } else {
            for (int i = 0; i < reportTop.getData().length; i++) {
                System.out.printf("%-20s %5s %n", reportTop.getData()[i].getName(), reportTop.getData()[i].getCount());
                System.out.println("-".repeat(dash));
            }
            System.out.println("=".repeat(dash));
        }
    }
}


