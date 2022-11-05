package com.jan.magicmarket.config.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductCategory implements Labeled<String> {
    MAGIC_CARD("Magic card"),
    MAGIC_BOOSTER_PACK("Magic booster pack"),
    MAGIC_BOOSTER_BOX("Magic booster box"),
    MAGIC_STARTER_DECK("Magic starter deck"),
    ACCESSORY("Accessory");

    private final String label;

    ProductCategory(String label) {
        this.label = label;
    }

    @JsonValue
    @Override
    public String getLabel() {
        return label;
    }
}
