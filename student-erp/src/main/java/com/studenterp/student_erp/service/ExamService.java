package com.studenterp.student_erp.service;

import com.studenterp.student_erp.Entity.Exam;
import com.studenterp.student_erp.Entity.Student;
import com.studenterp.student_erp.repository.ExamRepository;
import com.studenterp.student_erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Exam addExam(Long studentId, String subject, double marksObtained, double totalMarks) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;

        String grade = calculateGrade(marksObtained, totalMarks);
        Exam exam = new Exam(student, subject, marksObtained, totalMarks, grade);
        return examRepository.save(exam);
    }

    public List<Exam> getExamsByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;
        return examRepository.findByStudent(student);
    }

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    private String calculateGrade(double marksObtained, double totalMarks) {
        double percentage = (marksObtained / totalMarks) * 100;
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }
}
