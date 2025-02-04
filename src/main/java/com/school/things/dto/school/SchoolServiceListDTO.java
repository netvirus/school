package com.school.things.dto.school;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class SchoolServiceListDTO {
    private Long id;
    private String serviceName;

    public SchoolServiceListDTO() {
    }
}
