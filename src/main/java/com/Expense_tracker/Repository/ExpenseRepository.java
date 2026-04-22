package com.Expense_tracker.Repository;

import com.Expense_tracker.Category;
import com.Expense_tracker.Model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByCategory(Category category);

    List<Expense> findByExpenseDateBetween(LocalDate startDate, LocalDate endDate);

    @Query("SELECT e FROM Expense e WHERE MONTH(e.expenseDate) = :month AND YEAR(e.expenseDate) = :year")
    List<Expense> findByMonthAndYear(int month, int year);
}
