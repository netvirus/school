package com.school.things.entities.pricelist;

import jakarta.persistence.MappedSuperclass;

public class BasePrice {
    private int gradeLevelId;
    private double annualModulesFee;           // ANNUAL MODULES FEE
    private double legacyTlp;                  // LEGACY / TLP
    private double uniform;                    // UNIFORM
    private double food;                       // FOOD
    private double annualMiscellaneousFee;     // ANNUAL MISCELANEOUS FEE
    private double fieldTripCampRecognition;   // Field Trip / Camp & Recognition
    private double lsaFeeOneTime;              // LSA FEE (ONE TIME)
    private double registrationFeeOneTime;     // REGISTRATION FEE (ONE TIME)

    public BasePrice(int gradeLevelId, double annualModulesFee, double legacyTlp, double uniform, double food, double annualMiscellaneousFee, double fieldTripCampRecognition, double lsaFeeOneTime, double registrationFeeOneTime) {
        this.gradeLevelId = gradeLevelId;
        this.annualModulesFee = annualModulesFee;
        this.legacyTlp = legacyTlp;
        this.uniform = uniform;
        this.food = food;
        this.annualMiscellaneousFee = annualMiscellaneousFee;
        this.fieldTripCampRecognition = fieldTripCampRecognition;
        this.lsaFeeOneTime = lsaFeeOneTime;
        this.registrationFeeOneTime = registrationFeeOneTime;
    }

    public int getGradeLevelId() {
        return gradeLevelId;
    }

    public void setGradeLevelId(int gradeLevelId) {
        this.gradeLevelId = gradeLevelId;
    }

    public double getAnnualModulesFee() {
        return annualModulesFee;
    }

    public void setAnnualModulesFee(double annualModulesFee) {
        this.annualModulesFee = annualModulesFee;
    }

    public double getLegacyTlp() {
        return legacyTlp;
    }

    public void setLegacyTlp(double legacyTlp) {
        this.legacyTlp = legacyTlp;
    }

    public double getUniform() {
        return uniform;
    }

    public void setUniform(double uniform) {
        this.uniform = uniform;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getAnnualMiscellaneousFee() {
        return annualMiscellaneousFee;
    }

    public void setAnnualMiscellaneousFee(double annualMiscellaneousFee) {
        this.annualMiscellaneousFee = annualMiscellaneousFee;
    }

    public double getFieldTripCampRecognition() {
        return fieldTripCampRecognition;
    }

    public void setFieldTripCampRecognition(double fieldTripCampRecognition) {
        this.fieldTripCampRecognition = fieldTripCampRecognition;
    }

    public double getLsaFeeOneTime() {
        return lsaFeeOneTime;
    }

    public void setLsaFeeOneTime(double lsaFeeOneTime) {
        this.lsaFeeOneTime = lsaFeeOneTime;
    }

    public double getRegistrationFeeOneTime() {
        return registrationFeeOneTime;
    }

    public void setRegistrationFeeOneTime(double registrationFeeOneTime) {
        this.registrationFeeOneTime = registrationFeeOneTime;
    }
}

