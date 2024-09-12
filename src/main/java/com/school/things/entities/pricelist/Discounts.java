package com.school.things.entities.pricelist;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Discounts {
    private double _discountAnnualModulesFee = 0;
    private double discountLegacyTlp = 0;
    private double discountUniform = 0;
    private double discountFood = 0;
    private double discountAnnualMiscellaneousFee = 0;
    private double discountFieldTripCampRecognition = 0;
    private double discountLsaFeeOneTime = 0;
    private double discountRegistrationFeeOneTime = 0;
}

