package com.Expense_tracker.Service;

import com.Expense_tracker.Model.MonthlyBudget;
import com.Expense_tracker.Repository.MonthlyBudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    MonthlyBudgetRepository budgetRepository;


    public Object setBudget(MonthlyBudget budget) {
        if (budget.getMonth() == null || budget.getMonth() < 1 || budget.getMonth() > 12) {
            return "Month must be between 1 and 12";
        }
        if (budget.getYear() == null || budget.getYear() < 2000) {
            return "Enter valid year";
        }
        if (budget.getAmount() == null || budget.getAmount() <= 0) {
            return "Budget amount must be greater than 0";
        }

        Optional<MonthlyBudget> existingBudget = budgetRepository.findByMonthAndYear(budget.getMonth(), budget.getYear());

        if (existingBudget.isPresent()) {
            MonthlyBudget oldBudget = existingBudget.get();
            oldBudget.setAmount(budget.getAmount());
            return budgetRepository.save(oldBudget);
        }

        return budgetRepository.save(budget);
    }

    public MonthlyBudget getBudget(int month, int year) {
        return budgetRepository.findByMonthAndYear(month, year).orElse(null);
    }
}