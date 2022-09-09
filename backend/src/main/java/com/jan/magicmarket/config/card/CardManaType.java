package com.jan.magicmarket.config.card;

public enum CardManaType {
    WHITE("White"),
    BLUE("Blue"),
    BLACK("Black"),
    RED("Red"),
    GREEN("Green"),
    COLORLESS("Colorless");

    private final String name;

    CardManaType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
