package com.school.things.dto;

public class PriceServiceListDTO {
    private Long id;
    private int cost;
    private Long schoolServiceId;
    private String schoolServiceName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Long getSchoolServiceId() {
        return schoolServiceId;
    }

    public void setSchoolServiceId(Long schoolServiceId) {
        this.schoolServiceId = schoolServiceId;
    }

    public String getSchoolServiceName() {
        return schoolServiceName;
    }

    public void setSchoolServiceName(String schoolServiceName) {
        this.schoolServiceName = schoolServiceName;
    }
}
