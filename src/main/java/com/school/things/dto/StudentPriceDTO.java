package com.school.things.dto;

public class StudentPriceDTO {
    private Long id;
    private PriceDTO priceDto;
    private Boolean isActive = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PriceDTO getPriceDto() {
        return priceDto;
    }

    public void setPriceDto(PriceDTO priceDto) {
        this.priceDto = priceDto;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
