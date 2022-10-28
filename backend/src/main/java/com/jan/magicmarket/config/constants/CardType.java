package com.jan.magicmarket.config.constants;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jan.magicmarket.util.Labeled;

public enum CardType implements Labeled<String> {
    PLANESWALKER("Planeswalker"),
    CREATURE("Creature"),
    INSTANT("Instant"),
    SORCERY("Sorcery"),
    ENCHANTMENT("Enchantment"),
    ARTIFACT("Artifact"),
    LAND("Land");

    private final String label;

    CardType(String label) {
        this.label = label;
    }

    @JsonValue
    @Override
    public String getLabel() {
        return label;
    }
}
