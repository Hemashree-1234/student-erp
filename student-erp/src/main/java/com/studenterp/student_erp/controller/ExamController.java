package com.studenterp.student_erp.controller;

import com.studenterp.student_erp.Entity.Exam;
import com.studenterp.student_erp.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping("/add/{studentId}")
    public Exam addExam(
            @PathVariable Long studentId,
            @RequestParam String subject,
            @RequestParam double marksObtained,
            @RequestParam double totalMarks) {
        return examService.addExam(studentId, subject, marksObtained, totalMarks);
    }

    @GetMapping("/student/{studentId}")
    public List<Exam> getExamsByStudent(@PathVariable Long studentId) {
        return examService.getExamsByStudent(studentId);
    }

    @GetMapping
    public List<Exam> getAllExams() {
        return examService.getAllExams();
    }
}
