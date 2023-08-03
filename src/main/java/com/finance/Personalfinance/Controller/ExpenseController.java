package com.finance.Personalfinance.Controller;

import com.finance.Personalfinance.Dto.ExpDto;
import com.finance.Personalfinance.Dto.ExpenseDto;
import com.finance.Personalfinance.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/expens")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @PostMapping("/create/{categoryId}")
    @ResponseBody

    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto,@PathVariable int categoryId){
        ExpenseDto createExp = this.expenseService.createExpense(expenseDto,categoryId);
        return new ResponseEntity<ExpenseDto>(createExp, HttpStatus.ACCEPTED);

    }

    @GetMapping("/view")
    public ResponseEntity<List<ExpDto>> viewAll(){
        List<ExpDto> allrecord =this.expenseService.viewAll();
        return new ResponseEntity<>(allrecord,HttpStatus.OK);
    }
    @GetMapping("/MonthalyTotal")
    public ResponseEntity<Double> getTotalExpensesForMonth(@RequestParam("year") int year, @RequestParam("month") int month) {
        double totalExpenses = expenseService.getTotalExpensesForMonth(year, month);
        return ResponseEntity.ok(totalExpenses);
    }
    @GetMapping("/weekly")
    public ResponseEntity<Double> getWeeklyExpenses(@RequestParam("weekStartDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate weekStartDate) {
        LocalDate weekEndDate = weekStartDate.plusDays(6); // Add 6 days to get the end date (last day) of the week
        double totalWeeklyExpenses = expenseService.getTotalExpensesForWeek(weekStartDate, weekEndDate);
        return ResponseEntity.ok(totalWeeklyExpenses);
    }
    @GetMapping("/total")
    public ResponseEntity<Double> getTotalExpensesAmount() {
        double totalExpensesAmount = expenseService.getTotalExpensesAmount();
        return ResponseEntity.ok(totalExpensesAmount);
    }

}
