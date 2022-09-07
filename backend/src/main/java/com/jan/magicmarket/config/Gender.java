package com.jan.magicmarket.config;

public enum Gender {
    MALE('M'),
    FEMALE('F');

    private final char gender;

    Gender(char gender) {
        this.gender = gender;
    }

    public char getGender() {
        return gender;
    }
}
