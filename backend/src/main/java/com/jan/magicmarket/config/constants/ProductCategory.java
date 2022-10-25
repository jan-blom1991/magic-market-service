package com.jan.magicmarket.config.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProductCategory {
    MAGIC_CARD("Magic card"),
    MAGIC_BOOSTER_PACK("Magic booster pack"),
    MAGIC_BOOSTER_BOX("Magic booster box"),
    MAGIC_STARTER_DECK("Magic starter deck"),
    ACCESSORY("Accessory");

    private final String value;

    ProductCategory(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
