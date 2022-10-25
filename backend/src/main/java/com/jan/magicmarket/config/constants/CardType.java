package com.jan.magicmarket.config.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CardType {
    PLANESWALKER("Planeswalker"),
    CREATURE("Creature"),
    INSTANT("Instant"),
    SORCERY("Sorcery"),
    ENCHANTMENT("Enchantment"),
    ARTIFACT("Artifact"),
    LAND("Land");

    private final String value;

    CardType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
