package com.studenterp.student_erp.service;

import com.studenterp.student_erp.  Entity.Faculty;
import com.studenterp.student_erp.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty updateFaculty(Long id, Faculty updatedFaculty) {
        Faculty existing = facultyRepository.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setName(updatedFaculty.getName());
        existing.setEmail(updatedFaculty.getEmail());

        return facultyRepository.save(existing);
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }
}
