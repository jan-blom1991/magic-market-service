package com.jan.magicmarket.config.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CardColor {
    WHITE("White"),
    BLUE("Blue"),
    BLACK("Black"),
    RED("Red"),
    GREEN("Green"),
    MULTICOLOR("Multicolor"),
    COLORLESS("Colorless"),
    LAND("Land");

    private final String value;

    CardColor(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
