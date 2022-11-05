package com.jan.magicmarket.config.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender implements Labeled<String> {
    MALE("Male"),
    FEMALE("Female");

    private final String label;

    Gender(String label) {
        this.label = label;
    }

    @JsonValue
    @Override
    public String getLabel() {
        return label;
    }
}
