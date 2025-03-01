package com.school.things.services;

import com.school.things.dto.student.StudentDTO;
import com.school.things.dto.student.StudentListDTO;
import com.school.things.entities.student.Student;
import com.school.things.dto.StudentMapper;
import com.school.things.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    StudentMapper studentMapper;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::convertStudentToDTO)
                .collect(Collectors.toList());
    }

    public List<StudentListDTO> getStudentList() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::convertStudentToListDTO)
                .collect(Collectors.toList());
    }

    public Optional<StudentDTO> getStudentById(Long id) {
       return studentRepository.findById(id)
               .map(studentMapper::convertStudentToDTO);
    }

    public Student saveStudent(StudentDTO studentDto) {
        return studentRepository.save(studentMapper.convertStudentFromDTO(studentDto));
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
