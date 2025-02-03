package com.school.things.dto;

import com.school.things.entities.school.Price;
import com.school.things.entities.school.PriceServiceList;
import com.school.things.entities.school.SchoolServiceList;
import com.school.things.entities.student.StudentServiceList;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PriceMapper {
    public static PriceDTO convertPriceToDTO(Price price) {
        if (price == null) return null;

        return PriceDTO.builder()
                .id(price.getId())
                .name(price.getName())
                .priceServiceList(convertToListDTO(price.getPriceServiceList(), PriceMapper::convertToDTO))
                .studentServiceLists(convertToListDTO(price.getStudentServiceLists(), PriceMapper::convertToDTO))
                .build();
    }

    private static <T, R> List<R> convertToListDTO(List<T> sourceList, Function<T, R> converter) {
        return Optional.ofNullable(sourceList)
                .orElse(Collections.emptyList())
                .stream()
                .map(converter)
                .collect(Collectors.toList());
    }

    public static StudentServiceListDTO convertToDTO(StudentServiceList entity) {
        if (entity == null) return null;

        return StudentServiceListDTO.builder()
                .id(entity.getId())
                .discount(entity.getDiscount())
                .serviceName(Optional.ofNullable(entity.getPriceServiceList())
                        .map(PriceServiceList::getSchoolServiceList)
                        .map(SchoolServiceList::getServiceName)
                        .orElse(null))
                .serviceCost(Optional.ofNullable(entity.getPriceServiceList())
                        .map(PriceServiceList::getCost)
                        .orElse(null))
                .build();
    }

    public static PriceServiceListDTO convertToDTO(PriceServiceList entity) {
        if (entity == null) return null;

        return PriceServiceListDTO.builder()
                .id(entity.getId())
                .cost(entity.getCost())
                .schoolServiceId(Optional.ofNullable(entity.getSchoolServiceList())
                        .map(SchoolServiceList::getId)
                        .orElse(null))
                .schoolServiceName(Optional.ofNullable(entity.getSchoolServiceList())
                        .map(SchoolServiceList::getServiceName)
                        .orElse(null))
                .build();
    }
}
