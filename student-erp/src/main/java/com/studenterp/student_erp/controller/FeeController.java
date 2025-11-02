package com.studenterp.student_erp.controller;



import com.studenterp.student_erp.Entity.Fee;
import com.studenterp.student_erp.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    @Autowired
    private FeeService feeService;

    @PostMapping("/pay/{studentId}")
    public Fee payFee(@PathVariable Long studentId, @RequestParam double amount) {
        return feeService.payFee(studentId, amount);
    }

    @GetMapping("/student/{studentId}")
    public List<Fee> getFeesByStudent(@PathVariable Long studentId) {
        return feeService.getFeesByStudent(studentId);
    }

    @GetMapping
    public List<Fee> getAllFees() {
        return feeService.getAllFees();
    }
}