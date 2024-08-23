package com.school.things.services;

import com.school.things.entities.Student;
import com.school.things.entities.Teacher;
import com.school.things.entities.abstracts.Person;
import com.school.things.repositories.StudentRepository;
import com.school.things.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    // Метод для получения всех студентов
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Метод для получения студента по ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Метод для создания студента
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Метод для обновления студента
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id)
                .map(existingPerson -> {
                    copyCommonPersonData(existingPerson, student);
                    existingPerson.setGrade(student.getGrade());
                    existingPerson.setMotherName(student.getMotherName());
                    existingPerson.setFatherName(student.getFatherName());
                    existingPerson.setMotherPhoneNumber(student.getMotherPhoneNumber());
                    existingPerson.setFatherPhoneNumber(student.getFatherPhoneNumber());
                    return studentRepository.save(existingPerson);
                })
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // Метод для удаления студента
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    // Метод для получения всех учителей
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    // Метод для получения учителя по ID
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }

    // Метод для создания учителя
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    // Метод для обновления учителя
    public Teacher updateTeacher(Teacher teacher, Long id) {
        return teacherRepository.findById(id)
                .map(existingPerson -> {
                    copyCommonPersonData(existingPerson, teacher);
                    existingPerson.setSubject(teacher.getSubject());
                    existingPerson.setGrade(teacher.getGrade());
                    return teacherRepository.save(existingPerson);
                })
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    // Метод для удаления учителя
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    // Метод для копирования общих данных из Person
    private void copyCommonPersonData(Person existingPerson, Person newPerson) {
        existingPerson.setFirstName(newPerson.getFirstName());
        existingPerson.setLastName(newPerson.getLastName());
        existingPerson.setAge(newPerson.getAge());
        existingPerson.setGender(newPerson.getGender());
        existingPerson.setNationality(newPerson.getNationality());
        existingPerson.setPhoneNumber(newPerson.getPhoneNumber());
        existingPerson.setAddress(newPerson.getAddress());
    }
}
