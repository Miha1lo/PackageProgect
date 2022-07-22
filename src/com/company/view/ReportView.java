package com.company.view;

import com.company.dto.BuyingDto;
import com.company.dto.ReportDto;

public class ReportView {

    public static final String DESCRIPTION = "REPORT DATA: ";

    public void printDetails(ReportDto report) {
        int dash = 50;
        System.out.println("=".repeat(dash));
        System.out.println(DESCRIPTION + report.getName());
        System.out.println("=".repeat(dash));

        System.out.println("name\t\t\t\tcount\t\t\t\tsum");
        System.out.println("=".repeat(dash));
        for (BuyingDto buyingDto : report.getData()) {
            String cost = Math.round(buyingDto.getSum()) + " uah";
            System.out.printf("%-20s %5s %20s %n", buyingDto.getName(), buyingDto.getCount(), cost);
          //  System.out.println(buyingDto.getName() + "\t\t\t" + buyingDto.getCount() + "\t\t\t" + cost);
            System.out.println("-".repeat(dash));
        }
        System.out.println("=".repeat(dash));
        System.out.println("Total sum: " + report.getTotalSum() + " uah");
    }


}
