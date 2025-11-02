package com.studenterp.student_erp.controller;

import com.studenterp.student_erp.Entity.Attendance;
import com.studenterp.student_erp.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark/{studentId}")
    public Attendance markAttendance(@PathVariable Long studentId, @RequestParam boolean present) {
        return attendanceService.markAttendance(studentId, present);
    }

    @GetMapping("/student/{studentId}")
    public List<Attendance> getByStudent(@PathVariable Long studentId) {
        return attendanceService.getAttendanceByStudent(studentId);
    }

    @GetMapping("/date/{date}")
    public List<Attendance> getByDate(@PathVariable String date) {
        return attendanceService.getAttendanceByDate(LocalDate.parse(date));
    }

    @GetMapping
    public List<Attendance> getAll() {
        return attendanceService.getAllAttendance();
    }
}