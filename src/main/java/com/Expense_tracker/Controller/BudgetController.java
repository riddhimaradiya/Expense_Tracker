package com.Expense_tracker.Controller;

import com.Expense_tracker.Model.MonthlyBudget;
import com.Expense_tracker.Service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    BudgetService budgetService;

    @PostMapping
    public Object setBudget(@RequestBody MonthlyBudget budget) {
        return budgetService.setBudget(budget);
    }

    @GetMapping
    public Object getBudget(@RequestParam int month, @RequestParam int year) {
        MonthlyBudget budget = budgetService.getBudget(month, year);

        if (budget == null) {
            return "No budget found";
        }
        return budget;
    }
}
