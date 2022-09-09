package com.jan.magicmarket.config;

public enum ProductCategory {
    MAGIC_CARD("Magic card"),
    MAGIC_BOOSTER_PACK("Magic booster pack"),
    MAGIC_BOOSTER_BOX("Magic booster box"),
    MAGIC_STARTER_DECK("Magic starter deck"),
    ACCESSORY("Accessory");

    private final String name;

    ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
