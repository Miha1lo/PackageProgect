package com.company.dto;

public class ReportTopDto {

    private String name;
    private BuyingDto[] data;

    public ReportTopDto(String name, BuyingDto[] data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BuyingDto[] getData() {
        return data;
    }

    public void setData(BuyingDto[] data) {
        this.data = data;
    }
}
