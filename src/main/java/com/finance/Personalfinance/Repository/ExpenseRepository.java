package com.finance.Personalfinance.Repository;

import com.finance.Personalfinance.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
