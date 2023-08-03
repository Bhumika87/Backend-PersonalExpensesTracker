package com.finance.Personalfinance.Service;

import com.finance.Personalfinance.Dto.ExpDto;
import com.finance.Personalfinance.Dto.ExpenseDto;
import com.finance.Personalfinance.Exception.ResourceNotFoundException;
import com.finance.Personalfinance.Model.Category;
import com.finance.Personalfinance.Model.Expense;
import com.finance.Personalfinance.Repository.CategoryRepository;
import com.finance.Personalfinance.Repository.ExpenseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExpenseService {
    
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    
    public ExpenseDto createExpense(ExpenseDto expenseDto,int catId)
    {
        //complete information of category by using category id
        Category cat = this.categoryRepository.findById(catId).orElseThrow(()-> new ResourceNotFoundException("Category Id does not exist"));
        //dto ko entity m cha ge kena database m save krna k lia
        Expense exp = this.modelMapper.map(expenseDto,Expense.class);
        //parameter m jo category ayi hai usko expense m add krna
          exp.setCategory(cat);
        Expense newExpense = this.expenseRepository.save(exp);
        //return jo krna hai voh dto krna hai toh need to change dto
        return this.modelMapper.map(newExpense,ExpenseDto.class);
    }
    public List<ExpDto> viewAll()
    {
        List<Expense>exp =this.expenseRepository.findAll();
        List<ExpDto> expDto = exp.stream().map(expense -> {
            ExpDto dto = new ExpDto();
            dto.setExpenseName(expense.getExpenseName());
            dto.setAmount(expense.getAmount());
            dto.setDate(expense.getDate());
            dto.setCategoryName(expense.getCategory().getCategoryName());
            return dto;
        }).collect(Collectors.toList());

        return expDto;
    }
    public double getTotalExpensesForMonth(int year, int month) {
        //to find starting date of month
        LocalDate startDate = LocalDate.of(year, month, 1);
        //to find last date of month for example month m add krnge to next month ajayga or usme s ek din minus krnge to last day ajayga
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        List<Expense> expensesForMonth = expenseRepository.findByDateBetween(startDate, endDate);

        double totalExpenses = 0.0; // Initialize the total expenses to 0

        for (Expense expense : expensesForMonth) {
            totalExpenses += expense.getAmount();
        }

        return totalExpenses;
    }
    public double getTotalExpensesForWeek(LocalDate startDate, LocalDate endDate) {
        List<Expense> expensesForWeek = expenseRepository.findByDateBetween(startDate, endDate);

        double totalExpenses = 0.0; // Initialize the total expenses to 0

        for (Expense expense : expensesForWeek) {
            totalExpenses += expense.getAmount();
        }
        return totalExpenses;
    }
    public double getTotalExpensesAmount() {
        List<Expense> allExpenses = expenseRepository.findAll();

        double totalExpenses = 0.0; // Initialize the total expenses to 0

        for (Expense expense : allExpenses) {
            totalExpenses += expense.getAmount();
        }
        return totalExpenses;
    }

    
}
