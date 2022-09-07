package com.jan.magicmarket.config;

public enum OrderStatus {
    OPEN(0),
    PAID(1),
    FINISHED(2);

    private int status;

    OrderStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
