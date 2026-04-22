package com.Expense_tracker.Repository;

import com.Expense_tracker.Model.MonthlyBudget;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonthlyBudgetRepository extends JpaRepository<MonthlyBudget, Long> {
    Optional<MonthlyBudget> findByMonthAndYear(Integer month, Integer year);
}
