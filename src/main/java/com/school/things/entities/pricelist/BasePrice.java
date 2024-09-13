package com.school.things.entities.pricelist;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class BasePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int gradeLevelId;
    private double annualModulesFee;           // ANNUAL MODULES FEE
    private double legacyTlp;                  // LEGACY / TLP
    private double uniform;                    // UNIFORM
    private double food;                       // FOOD
    private double annualMiscellaneousFee;     // ANNUAL MISCELANEOUS FEE
    private double fieldTripCampRecognition;   // Field Trip / Camp & Recognition
    private double lsaFeeOneTime;              // LSA FEE (ONE TIME)
    private double registrationFeeOneTime;     // REGISTRATION FEE (ONE TIME)

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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

