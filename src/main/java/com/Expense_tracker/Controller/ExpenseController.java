package com.Expense_tracker.Controller;

import com.Expense_tracker.Category;
import com.Expense_tracker.Model.Expense;
import com.Expense_tracker.Service.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Object addExpense(@RequestBody Expense expense) {
        return expenseService.addExpense(expense);
    }

    @PutMapping("/{id}")
    public Object updateExpense(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public Object deleteExpense(@PathVariable Long id) {
        return expenseService.deleteExpense(id);
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/paged")
    public Page<Expense> getAllExpensesWithPagination(@RequestParam int page,
                                                      @RequestParam int size) {
        return expenseService.getAllExpensesWithPagination(page, size);
    }

    @GetMapping("/category/{category}")
    public List<Expense> getByCategory(@PathVariable Category category) {
        return expenseService.getByCategory(category);
    }

    @GetMapping("/date-range")
    public List<Expense> getByDateRange(@RequestParam LocalDate startDate,
                                        @RequestParam LocalDate endDate) {
        return expenseService.getByDateRange(startDate, endDate);
    }

    @GetMapping("/total")
    public Double getTotalSpending() {
        return expenseService.getTotalSpending();
    }
}
