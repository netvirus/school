package com.school.things.dto;

import com.school.things.entities.student.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {
    public static Student toStudent(StudentDTO studentDTO) {
        return new Student(
                studentDTO.getId(),
                studentDTO.getFirstName(),
                studentDTO.getLastName(),
                studentDTO.getAge(),
                studentDTO.getGender(),
                studentDTO.getNationality(),
                studentDTO.getPhoneNumber(),
                studentDTO.getAddress(),
                studentDTO.getCreatedAt(),
                studentDTO.getGrade(),
                studentDTO.getMotherName(),
                studentDTO.getFatherName(),
                studentDTO.getMotherPhoneNumber(),
                studentDTO.getFatherPhoneNumber());
    }

    public static List<Student> toStudents(List<StudentDTO> studentDTOs) {
        List<Student> students = new ArrayList<>();

        for (StudentDTO studentDTO : studentDTOs) {
            Student student = new Student(
                    studentDTO.getId(),
                    studentDTO.getFirstName(),
                    studentDTO.getLastName(),
                    studentDTO.getAge(),
                    studentDTO.getGender(),
                    studentDTO.getNationality(),
                    studentDTO.getPhoneNumber(),
                    studentDTO.getAddress(),
                    studentDTO.getCreatedAt(),
                    studentDTO.getGrade(),
                    studentDTO.getMotherName(),
                    studentDTO.getFatherName(),
                    studentDTO.getMotherPhoneNumber(),
                    studentDTO.getFatherPhoneNumber()
            );
            students.add(student);
        }
        return students;
    }

    public static StudentDTO fromStudent(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getGender(),
                student.getNationality(),
                student.getPhoneNumber(),
                student.getAddress(),
                student.getCreatedAt(),
                student.getGrade(),
                student.getMotherName(),
                student.getFatherName(),
                student.getMotherPhoneNumber(),
                student.getFatherPhoneNumber()
        );
    }

    public static List<StudentDTO> fromStudents(List<Student> students) {
        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO(
                    student.getId(),
                    student.getFirstName(),
                    student.getLastName(),
                    student.getAge(),
                    student.getGender(),
                    student.getNationality(),
                    student.getPhoneNumber(),
                    student.getAddress(),
                    student.getCreatedAt(),
                    student.getGrade(),
                    student.getMotherName(),
                    student.getFatherName(),
                    student.getMotherPhoneNumber(),
                    student.getFatherPhoneNumber()
            );
            studentDTOs.add(studentDTO);
        }
        return studentDTOs;
    }
}
