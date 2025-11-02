package com.studenterp.student_erp.repository;



import com.studenterp.student_erp.Entity.Attendance;
import com.studenterp.student_erp.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByStudent(Student student);
    List<Attendance> findByDate(LocalDate date);
}