package com.finance.Personalfinance.Dto;

import java.time.LocalDate;

public class ExpenseDto {
    private int expenseId;
    private String expenseName;

    private double amount;

    private LocalDate date;
    private CategoryDto category;

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

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

    public ExpenseDto() {
    }

    public ExpenseDto(int expenseId, String expenseName, double amount) {
        this.expenseId = expenseId;
        this.expenseName = expenseName;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }
}
