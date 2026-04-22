package com.Expense_tracker.Service;

import com.Expense_tracker.Model.Expense;
import com.Expense_tracker.Model.MonthlyBudget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    ExpenseService expenseService;

    @Autowired
    BudgetService budgetService;

    public Map<String, Object> getCategoryWiseAnalysis() {
        List<Expense> expenses = expenseService.getAllExpenses();
        Map<String, Double> categoryMap = new HashMap<>();

        for (Expense expense : expenses) {
            String categoryName = expense.getCategory().name();
            categoryMap.put(categoryName,
                    categoryMap.getOrDefault(categoryName, 0.0) + expense.getAmount());
        }

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("categoryWiseSpending", categoryMap);
        return result;
    }

    public Map<String, Object> getMonthlySummary(int month, int year) {
        List<Expense> expenses = expenseService.getExpensesByMonthAndYear(month, year);

        double totalSpent = 0;
        int totalExpenses = expenses.size();

        for (Expense expense : expenses) {
            totalSpent += expense.getAmount();
        }

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("month", month);
        result.put("year", year);
        result.put("totalExpensesCount", totalExpenses);
        result.put("totalSpent", totalSpent);
        result.put("expenses", expenses);

        return result;
    }

    public Map<String, Object> getBudgetAlert(int month, int year) {
        MonthlyBudget budget = budgetService.getBudget(month, year);
        List<Expense> expenses = expenseService.getExpensesByMonthAndYear(month, year);

        double totalSpent = 0;
        for (Expense expense : expenses) {
            totalSpent += expense.getAmount();
        }

        Map<String, Object> result = new LinkedHashMap<>();

        if (budget == null) {
            result.put("message", "No budget found for this month and year");
            result.put("totalSpent", totalSpent);
            return result;
        }

        double budgetAmount = budget.getAmount();
        double remaining = budgetAmount - totalSpent;
        double percentageUsed = Math.round((totalSpent / budgetAmount) * 10000.0) / 100.0;
        result.put("budget", budgetAmount);
        result.put("totalSpent", totalSpent);
        result.put("remaining", remaining);
        result.put("percentageUsed", percentageUsed);

        if (totalSpent > budgetAmount) {
            result.put("alertMessage", "Budget exceeded!");
        } else {
            result.put("alertMessage", "You are within budget");
        }

        return result;
    }
}