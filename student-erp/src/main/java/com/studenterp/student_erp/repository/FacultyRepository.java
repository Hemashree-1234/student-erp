package com.studenterp.student_erp.repository;

import com.studenterp.student_erp.Entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByEmail(String email);
}