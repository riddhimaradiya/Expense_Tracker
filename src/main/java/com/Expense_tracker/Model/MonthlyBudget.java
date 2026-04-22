package com.Expense_tracker.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "monthly_budget")
public class MonthlyBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer month;

    private Integer year;

    private Double amount;

    public MonthlyBudget(){}

    public MonthlyBudget(Long id, Integer month, Integer year, Double amount) {
        this.id = id;
        this.month = month;
        this.year = year;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setId(Long id) {
        this.id = id;
    }
}