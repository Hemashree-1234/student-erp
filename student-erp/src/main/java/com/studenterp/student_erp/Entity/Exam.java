package com.studenterp.student_erp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exams")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(nullable = false)
    private String subject;

    @Column(nullable = false)
    private double marksObtained;

    @Column(nullable = false)
    private double totalMarks;

    @Column(nullable = false)
    private String grade;

    public Exam() {
    }

    public Exam(Student student, String subject, double marksObtained, double totalMarks, String grade) {
        this.student = student;
        this.subject = subject;
        this.marksObtained = marksObtained;
        this.totalMarks = totalMarks;
        this.grade = grade;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(double marksObtained) {
        this.marksObtained = marksObtained;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
