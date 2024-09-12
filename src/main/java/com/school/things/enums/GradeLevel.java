package com.school.things.enums;

public enum GradeLevel {
    G1,
    G2,
    G3,
    G4,
    G5,
    G6,
    G7,
    G8,
    G9,
    G10,
    G11,
    G12,
    K1,
    K2;

    public static String getGradeByOrder(int order) {
        for (GradeLevel gradeLevel : GradeLevel.values()) {
            if (gradeLevel.ordinal() == order) {
                return gradeLevel.name();
            }
        }
        throw new IllegalArgumentException("Invalid order for GradeLevel: " + order);
    }
}
