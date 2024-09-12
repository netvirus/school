package com.school.things.entities.pricelist;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PersonalDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long studentId;
    private double discountAnnualModulesFee = 0;
    private double discountLegacyTlp = 0;
    private double discountUniform = 0;
    private double discountFood = 0;
    private double discountAnnualMiscellaneousFee = 0;
    private double discountFieldTripCampRecognition = 0;
    private double discountLsaFeeOneTime = 0;
    private double discountRegistrationFeeOneTime = 0;

    public PersonalDiscount(Long studentId, double discountAnnualModulesFee, double discountLegacyTlp, double discountUniform, double discountFood, double discountAnnualMiscellaneousFee, double discountFieldTripCampRecognition, double discountLsaFeeOneTime, double discountRegistrationFeeOneTime) {
        this.studentId = studentId;
        this.discountAnnualModulesFee = discountAnnualModulesFee;
        this.discountLegacyTlp = discountLegacyTlp;
        this.discountUniform = discountUniform;
        this.discountFood = discountFood;
        this.discountAnnualMiscellaneousFee = discountAnnualMiscellaneousFee;
        this.discountFieldTripCampRecognition = discountFieldTripCampRecognition;
        this.discountLsaFeeOneTime = discountLsaFeeOneTime;
        this.discountRegistrationFeeOneTime = discountRegistrationFeeOneTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public double getDiscountAnnualModulesFee() {
        return discountAnnualModulesFee;
    }

    public void setDiscountAnnualModulesFee(double discountAnnualModulesFee) {
        this.discountAnnualModulesFee = discountAnnualModulesFee;
    }

    public double getDiscountLegacyTlp() {
        return discountLegacyTlp;
    }

    public void setDiscountLegacyTlp(double discountLegacyTlp) {
        this.discountLegacyTlp = discountLegacyTlp;
    }

    public double getDiscountUniform() {
        return discountUniform;
    }

    public void setDiscountUniform(double discountUniform) {
        this.discountUniform = discountUniform;
    }

    public double getDiscountFood() {
        return discountFood;
    }

    public void setDiscountFood(double discountFood) {
        this.discountFood = discountFood;
    }

    public double getDiscountAnnualMiscellaneousFee() {
        return discountAnnualMiscellaneousFee;
    }

    public void setDiscountAnnualMiscellaneousFee(double discountAnnualMiscellaneousFee) {
        this.discountAnnualMiscellaneousFee = discountAnnualMiscellaneousFee;
    }

    public double getDiscountFieldTripCampRecognition() {
        return discountFieldTripCampRecognition;
    }

    public void setDiscountFieldTripCampRecognition(double discountFieldTripCampRecognition) {
        this.discountFieldTripCampRecognition = discountFieldTripCampRecognition;
    }

    public double getDiscountLsaFeeOneTime() {
        return discountLsaFeeOneTime;
    }

    public void setDiscountLsaFeeOneTime(double discountLsaFeeOneTime) {
        this.discountLsaFeeOneTime = discountLsaFeeOneTime;
    }

    public double getDiscountRegistrationFeeOneTime() {
        return discountRegistrationFeeOneTime;
    }

    public void setDiscountRegistrationFeeOneTime(double discountRegistrationFeeOneTime) {
        this.discountRegistrationFeeOneTime = discountRegistrationFeeOneTime;
    }
}
