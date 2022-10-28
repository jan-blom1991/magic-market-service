package com.jan.magicmarket.config.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jan.magicmarket.util.Labeled;

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
