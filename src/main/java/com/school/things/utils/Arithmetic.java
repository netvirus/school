package com.school.things.utils;

public class Arithmetic {
    public static double Discount(double discount, double price) {
        return (price - (price * discount / 100));
    }
}
