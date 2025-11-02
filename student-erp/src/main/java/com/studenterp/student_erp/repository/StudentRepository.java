package com.studenterp.student_erp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.studenterp.student_erp.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}