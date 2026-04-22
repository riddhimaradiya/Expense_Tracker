package com.Expense_tracker.Controller;

import com.Expense_tracker.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/category-analysis")
    public Map<String, Object> getCategoryWiseAnalysis() {
        return reportService.getCategoryWiseAnalysis();
    }

    @GetMapping("/monthly-summary")
    public Map<String, Object> getMonthlySummary(@RequestParam int month,
                                                 @RequestParam int year) {
        return reportService.getMonthlySummary(month, year);
    }

    @GetMapping("/budget-alert")
    public Map<String, Object> getBudgetAlert(@RequestParam int month,
                                              @RequestParam int year) {
        return reportService.getBudgetAlert(month, year);
    }
}