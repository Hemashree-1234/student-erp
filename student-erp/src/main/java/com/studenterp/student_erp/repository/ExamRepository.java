package com.studenterp.student_erp.repository;



import com.studenterp.student_erp.Entity.Exam;
import com.studenterp.student_erp.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByStudent(Student student);
}