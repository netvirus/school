package com.school.things.dto;

import java.util.List;

public class PriceDTO {
    private Long id;
    private String name;
    private List<PriceServiceListDTO> priceServiceList;
    private List<StudentServiceListDTO> studentServiceLists;

    public PriceDTO() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PriceServiceListDTO> getPriceServicesList() {
        return priceServiceList;
    }

    public void setPriceServicesList(List<PriceServiceListDTO> priceServiceList) {
        this.priceServiceList = priceServiceList;
    }

    public List<StudentServiceListDTO> getStudentServicesList() {
        return studentServiceLists;
    }

    public void setStudentServicesList(List<StudentServiceListDTO> studentServiceLists) {
        this.studentServiceLists = studentServiceLists;
    }
}
