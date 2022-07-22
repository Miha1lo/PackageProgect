package com.company.service;

import com.company.dto.BuyingDto;
import com.company.dto.ReportDto;
import com.company.dto.ReportTopDto;
import com.company.dto.StoreDto;
import com.company.model.Store;
import com.company.model.product.Buying;

import java.util.Arrays;

public class ReportService {

    public static final String SUMMARY_REPORT = "Summary report";
    public static final String TOP_REPORT = "Top report";

    private Store[] stores;

    public ReportService(Store[] stores) {
        this.stores = stores;
    }

    public ReportDto build() {
        StoreDto[] storeDtos = mapStores();
        BuyingDto[] buyingDtos = mergeBuyings(storeDtos);
        double totalSum = 0;
        for (BuyingDto buyingDto : buyingDtos) {
            totalSum += buyingDto.getSum();
        }
        return new ReportDto(SUMMARY_REPORT, buyingDtos, totalSum);
    }

    public ReportTopDto buildTop(ReportDto report) {
        BuyingDto[] buyingTopDtos = report.getData();
        BuyingDto temp;
        for (int i = 0; i < buyingTopDtos.length; i++) {
            for (int j = 0; j < buyingTopDtos.length - 1 - i; j++) {
                if (buyingTopDtos[j].getCount() < buyingTopDtos[j + 1].getCount()) {
                    temp = buyingTopDtos[j];
                    buyingTopDtos[j] = buyingTopDtos[j + 1];
                    buyingTopDtos[j + 1] = temp;
                }
            }
        }
        return new ReportTopDto(TOP_REPORT, buyingTopDtos);
    }


    private BuyingDto[] mergeBuyings(StoreDto[] storeDtos) {
        int count = getCount(storeDtos);
        BuyingDto[] totalArr = new BuyingDto[count];
        int i = 0;
        for (StoreDto storeDto : storeDtos) {
            for (BuyingDto sell : storeDto.getSells()) {
                totalArr[i++] = sell;
            }
        }
        return totalArr;
    }

    private int getCount(StoreDto[] storeDtos) {
        int count = 0;
        for (StoreDto storeDto : storeDtos) {
            count += storeDto.getSells().length;
        }
        return count;
    }

    private StoreDto[] mapStores() {
        StoreDto[] array = new StoreDto[stores.length];
        for (int i = 0; i < array.length; i++) {
            Store store = stores[i];
            String name = store.getName();
            BuyingDto[] buyingDtos = new BuyingDto[store.getSales().length];
            for (int j = 0; j < store.getSales().length; j++) {
                Buying sale = store.getSales()[j];
                double sum = sale.getProduct().getCost() * sale.getCount();
                buyingDtos[j] = new BuyingDto(sale.getProduct().getName(), sale.getCount(), sum);
            }
            array[i] = new StoreDto(name, buyingDtos);
        }
        return array;
    }
}

