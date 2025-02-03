package com.school.things.dto.student;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String nationality;
    private String phoneNumber;
    private String address;
    private Date createdAt;
    private String grade;
    private String motherName;
    private String fatherName;
    private String motherPhoneNumber;
    private String fatherPhoneNumber;
    private List<StudentPriceDTO> studentPricesDto;

    public StudentDTO() { }
}
