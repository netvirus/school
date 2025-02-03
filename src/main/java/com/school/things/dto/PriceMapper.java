package com.school.things.dto;

import com.school.things.entities.school.Price;
import com.school.things.entities.school.PriceServiceList;
import com.school.things.entities.student.StudentServiceList;

import java.util.List;
import java.util.stream.Collectors;

public class PriceMapper {
    public static PriceDTO convertPriceToPriceDTO(Price price) {
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setId(price.getId());
        priceDTO.setName(price.getName());
        priceDTO.setPriceServicesList(convertPriceServicesListToPriceServicesListDTO(price.getPriceServiceList()));
        priceDTO.setStudentServicesList(convertStudentServicesListToStudentServicesListDTO(price.getStudentServiceLists()));
        return priceDTO;
    }

    public static List<StudentServiceListDTO> convertStudentServicesListToStudentServicesListDTO(List<StudentServiceList> studentServiceLists) {
        return studentServiceLists.stream()
                .map(PriceMapper::convertStudentServiceListToStudentServiceListDTO)
                .collect(Collectors.toList());
    }

    public static List<PriceServiceListDTO> convertPriceServicesListToPriceServicesListDTO(List<PriceServiceList> priceServiceLists) {
        return priceServiceLists.stream()
                .map(PriceMapper::convertPriceServiceListToPriceServiceListDTO)
                .collect(Collectors.toList());
    }

    public static StudentServiceListDTO convertStudentServiceListToStudentServiceListDTO(StudentServiceList studentServiceList) {
        StudentServiceListDTO studentServiceListDTO = new StudentServiceListDTO();
        studentServiceListDTO.setId(studentServiceList.getId());
        studentServiceListDTO.setDiscount(studentServiceList.getDiscount());
        studentServiceListDTO.setServiceName(studentServiceList.getPriceServiceList().getSchoolServiceList().getServiceName());
        studentServiceListDTO.setServiceCost(studentServiceList.getPriceServiceList().getCost());
        return studentServiceListDTO;
    }

    public static PriceServiceListDTO convertPriceServiceListToPriceServiceListDTO(PriceServiceList priceServiceList) {
        PriceServiceListDTO priceServiceListDTO = new PriceServiceListDTO();
        priceServiceListDTO.setId(priceServiceList.getId());
        priceServiceListDTO.setCost(priceServiceList.getCost());
        priceServiceListDTO.setSchoolServiceId(priceServiceList.getSchoolServiceList().getId());
        priceServiceListDTO.setSchoolServiceName(priceServiceList.getSchoolServiceList().getServiceName());
        return priceServiceListDTO;
    }
}
