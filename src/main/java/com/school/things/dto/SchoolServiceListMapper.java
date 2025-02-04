package com.school.things.dto;

import com.school.things.dto.school.SchoolServiceListDTO;
import com.school.things.entities.school.SchoolServiceList;

public class SchoolServiceListMapper {
    public static SchoolServiceListDTO convertToDTO(SchoolServiceList schoolServiceList) {
        if (schoolServiceList == null) return null;

        return SchoolServiceListDTO.builder()
                .id(schoolServiceList.getId())
                .serviceName(schoolServiceList.getServiceName())
                .build();
    }

    public static SchoolServiceList convertFromDTO(SchoolServiceListDTO schoolServiceListDTO) {
        if (schoolServiceListDTO == null) return null;

        return SchoolServiceList.builder()
                .id(schoolServiceListDTO.getId())
                .serviceName(schoolServiceListDTO.getServiceName())
                .build();
    }
}
