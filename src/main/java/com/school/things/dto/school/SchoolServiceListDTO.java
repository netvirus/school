package com.school.things.dto.school;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class SchoolServiceListDTO {
    private Long id;
    private String serviceName;

    public SchoolServiceListDTO() {
    }
}
