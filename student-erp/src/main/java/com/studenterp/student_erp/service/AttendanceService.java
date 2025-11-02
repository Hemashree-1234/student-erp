package com.studenterp.student_erp.service;



import com.studenterp.student_erp.Entity.Attendance;
import com.studenterp.student_erp.Entity.Student;
import com.studenterp.student_erp.repository.AttendanceRepository;
import com.studenterp.student_erp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Attendance markAttendance(Long studentId, boolean present) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;

        Attendance attendance = new Attendance(student, LocalDate.now(), present);
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendanceByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) return null;
        return attendanceRepository.findByStudent(student);
    }

    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
}