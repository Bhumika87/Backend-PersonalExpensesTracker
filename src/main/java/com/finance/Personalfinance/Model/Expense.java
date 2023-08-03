package com.finance.Personalfinance.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int expenseId;
    private String expenseName;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private LocalDate date;
    @PrePersist
    private void prePersist() {
        date = LocalDate.now();
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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

    public Expense() {
    }

    public Expense(int expenseId, String expenseName, double amount, LocalDate date, Category category) {
        this.expenseId = expenseId;
        this.expenseName = expenseName;
        this.amount = amount;
        this.date = date;
        this.category = category;
    }
}
