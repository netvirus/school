package com.school.things.services;

import com.school.things.entities.Teacher;
import com.school.things.repositories.TeacherRepository;
import com.school.things.utils.PersonDataCopier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private PersonDataCopier personDataCopier;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Teacher teacher, Long id) {
        return teacherRepository.findById(id)
                .map(existingTeacher -> {
                    personDataCopier.copyCommonPersonData(existingTeacher, teacher);
                    existingTeacher.setSubject(teacher.getSubject());
                    existingTeacher.setGrade(teacher.getGrade());
                    return teacherRepository.save(existingTeacher);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
