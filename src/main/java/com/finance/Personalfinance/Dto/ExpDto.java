package com.finance.Personalfinance.Dto;

import java.time.LocalDate;

public class ExpDto {

    private String expenseName;
    private double amount;
    private LocalDate date;
    private String categoryName;

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ExpDto(String expenseName, double amount, LocalDate date, String categoryName) {
        this.expenseName = expenseName;
        this.amount = amount;
        this.date = date;
        this.categoryName = categoryName;
    }

    public ExpDto() {
    }
}
