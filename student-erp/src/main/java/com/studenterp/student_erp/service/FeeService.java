package com.studenterp.student_erp.service;

import com.studenterp.student_erp.Entity.Fee;
import com.studenterp.student_erp.Entity.Student;
import com.studenterp.student_erp.repository.FeeRepository;
import com.studenterp.student_erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FeeService {

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Fee payFee(Long studentId, double amount) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;

        Fee fee = new Fee(student, amount, true, LocalDate.now());
        return feeRepository.save(fee);
    }

    public List<Fee> getFeesByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;

        return feeRepository.findByStudent(student);
    }

    public List<Fee> getAllFees() {
        return feeRepository.findAll();
    }
}