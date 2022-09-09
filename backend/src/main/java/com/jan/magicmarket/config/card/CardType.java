package com.jan.magicmarket.config.card;

public enum CardType {
    PLANESWALKER("Planeswalker"),
    CREATURE("Creature"),
    INSTANT("Instant"),
    SORCERY("Sorcery"),
    ENCHANTMENT("Enchantment"),
    ARTIFACT("Artifact"),
    LAND("Land");

    private final String name;

    CardType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
