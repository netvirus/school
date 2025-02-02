package com.school.things.dto;

import com.school.things.entities.student.Student;
import com.school.things.entities.student.StudentPrice;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMapper {
    public static StudentDTO convertStudentToStudentDTO(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setAge(student.getAge());
        studentDTO.setGender(student.getGender());
        studentDTO.setNationality(student.getNationality());
        studentDTO.setPhoneNumber(student.getPhoneNumber());
        studentDTO.setAddress(student.getAddress());
        studentDTO.setCreatedAt(student.getCreatedAt());
        studentDTO.setGrade(student.getGrade());
        studentDTO.setMotherName(student.getMotherName());
        studentDTO.setFatherName(student.getFatherName());
        studentDTO.setMotherPhoneNumber(student.getMotherPhoneNumber());
        studentDTO.setFatherPhoneNumber(student.getFatherPhoneNumber());
        studentDTO.setStudentPricesDTO(convertStudentPriceToStudentPriceDTO(student.getStudentPrices()));
        return studentDTO;
    }

    public static List<StudentPriceDTO> convertStudentPriceToStudentPriceDTO(List<StudentPrice> studentPrices) {
        return studentPrices.stream()
                .map(StudentMapper::convertStudentPriceToStudentPriceDTO)
                .collect(Collectors.toList());
    }

    public static StudentPriceDTO convertStudentPriceToStudentPriceDTO(StudentPrice studentPrice) {
        StudentPriceDTO studentPriceDTO = new StudentPriceDTO();
        studentPriceDTO.setId(studentPrice.getId());
        studentPriceDTO.setPrice(studentPrice.getPrice());
        studentPriceDTO.setActive(studentPrice.getActive());
        return studentPriceDTO;
    }
}
