package com.school.things.dto.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class StudentListDTO {
    private Long id;
    private String fullName;
    private String gender;
    private String nationality;
    private Boolean hasContacts;
    private Boolean hasParentsContacts;
    private String grade;
    private Boolean hasStudentPrice;
    private Boolean hasDiscount;
    private Boolean paymentState;
}
