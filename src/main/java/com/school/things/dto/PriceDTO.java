package com.school.things.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class PriceDTO {
    private Long id;
    private String name;
    private List<PriceServiceListDTO> priceServiceList;
    private List<StudentServiceListDTO> studentServiceLists;
}
