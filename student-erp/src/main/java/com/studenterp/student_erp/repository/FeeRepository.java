package com.studenterp.student_erp.repository;

import com.studenterp.student_erp.Entity.Fee;
import com.studenterp.student_erp.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Long> {
    List<Fee> findByStudent(Student student);
}