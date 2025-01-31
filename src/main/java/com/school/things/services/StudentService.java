package com.school.things.services;

import com.school.things.entities.student.Student;
import com.school.things.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id)
                .map(existingStudent -> {
                    existingStudent.setGrade(student.getGrade());
                    existingStudent.setMotherName(student.getMotherName());
                    existingStudent.setFatherName(student.getFatherName());
                    existingStudent.setMotherPhoneNumber(student.getMotherPhoneNumber());
                    existingStudent.setFatherPhoneNumber(student.getFatherPhoneNumber());
                    return studentRepository.save(existingStudent);
                })
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
