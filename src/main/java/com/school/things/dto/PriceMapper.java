package com.school.things.dto;

import com.school.things.dto.price.PriceDTO;
import com.school.things.dto.price.PriceServiceListDTO;
import com.school.things.entities.price.Price;
import com.school.things.entities.price.PriceServiceList;
import com.school.things.entities.school.SchoolServiceList;

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
//                .studentServiceLists(convertToListDTO(price.getStudentServiceDiscountLists(), StudentMapper::convertStudentServiceListToDTO))
//                .paymentPeriod(PaymentMapper.convertPaymentPeriodToDTO(price.getPaymentPeriod()))
                .build();
    }

    private static <T, R> List<R> convertToListDTO(List<T> sourceList, Function<T, R> converter) {
        return Optional.ofNullable(sourceList)
                .orElse(Collections.emptyList())
                .stream()
                .map(converter)
                .collect(Collectors.toList());
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

    public static Price convertPriceFromDTO(PriceDTO priceDto) {
        if (priceDto == null) return null;

        return Price.builder()
                .id(priceDto.getId())
                .name(priceDto.getName())
//                .paymentPeriod(PaymentMapper.convertPaymentPeriodFromDTO(priceDto.getPaymentPeriod()))
                .build();
    }
}
