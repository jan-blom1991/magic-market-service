package com.jan.magicmarket.config.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CardColor implements Labeled<String> {
    WHITE("White"),
    BLUE("Blue"),
    BLACK("Black"),
    RED("Red"),
    GREEN("Green"),
    MULTICOLOR("Multicolor"),
    COLORLESS("Colorless"),
    LAND("Land");

    private final String label;

    CardColor(String label) {
        this.label = label;
    }

    @JsonValue
    @Override
    public String getLabel() {
        return label;
    }
}
