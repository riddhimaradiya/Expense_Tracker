package com.Expense_tracker.Service;

import com.Expense_tracker.Category;
import com.Expense_tracker.Model.Expense;
import com.Expense_tracker.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    public Object addExpense(Expense expense) {
        if (expense.getTitle() == null || expense.getTitle().trim().isEmpty()) {
            return "Title is required";
        }
        if (expense.getAmount() == null || expense.getAmount() <= 0) {
            return "Amount must be greater than 0";
        }
        if (expense.getCategory() == null) {
            return "Category is required";
        }
        if (expense.getExpenseDate() == null) {
            return "Expense date is required";
        }

        expense.setCreatedAt(LocalDateTime.now());
        return expenseRepository.save(expense);
    }

    public Object updateExpense(Long id, Expense expense) {

        Optional<Expense> optionalExpense = expenseRepository.findById(id);

        if (optionalExpense.isEmpty()) {
            return "Expense not found with id: " + id;
        }

        if (expense.getTitle() == null || expense.getTitle().trim().isEmpty()) {
            return "Title is required";
        }
        if (expense.getAmount() == null || expense.getAmount() <= 0) {
            return "Amount must be greater than 0";
        }
        if (expense.getCategory() == null) {
            return "Category is required";
        }
        if (expense.getExpenseDate() == null) {
            return "Expense date is required";
        }

        Expense existingExpense = optionalExpense.get();
        existingExpense.setTitle(expense.getTitle());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setCategory(expense.getCategory());
        existingExpense.setExpenseDate(expense.getExpenseDate());
        existingExpense.setNote(expense.getNote());

        return expenseRepository.save(existingExpense);
    }

    public Object deleteExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);

        if (optionalExpense.isEmpty()) {
            return "Expense not found with id: " + id;
        }

        expenseRepository.deleteById(id);
        return "Expense deleted successfully";
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Page<Expense> getAllExpensesWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return expenseRepository.findAll(pageable);
    }

    public List<Expense> getByCategory(Category category) {
        return expenseRepository.findByCategory(category);
    }

    public List<Expense> getByDateRange(LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByExpenseDateBetween(startDate, endDate);
    }

    public Double getTotalSpending() {
        List<Expense> expenses = expenseRepository.findAll();
        double total = 0;

        for (Expense expense : expenses) {
            total += expense.getAmount();
        }

        return total;
    }

    public List<Expense> getExpensesByMonthAndYear(int month, int year) {
        return expenseRepository.findByMonthAndYear(month, year);
    }
}