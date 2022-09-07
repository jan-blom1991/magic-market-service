package com.jan.magicmarket.config;

public enum Role {

    ADMINISTRATOR("ADMINISTRATOR"),
    MANAGER("MANAGER"),
    EMPLOYEE("EMPLOYEE"),
    CUSTOMER("CUSTOMER");

    private final String authority;

    Role(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
