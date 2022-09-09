package com.jan.magicmarket.config.card;

public enum CardColor {
    WHITE("White"),
    BLUE("Blue"),
    BLACK("Black"),
    RED("Red"),
    GREEN("Green"),
    MULTICOLOR("Multicolor"),
    COLORLESS("Colorless"),
    LAND("Land");

    private final String name;

    CardColor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
