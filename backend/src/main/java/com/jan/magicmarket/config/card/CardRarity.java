package com.jan.magicmarket.config.card;

public enum CardRarity {
    COMMON("Common"),
    UNCOMMON("Uncommon"),
    RARE("Rare"),
    MYTHIC_RARE("Mythic rare"),
    LAND("Land");

    private final String name;

    CardRarity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
