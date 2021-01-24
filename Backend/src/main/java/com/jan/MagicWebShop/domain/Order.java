package com.jan.MagicWebShop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime dateOfOrder;
    private LocalDateTime dateOfShipping;
    private boolean paid;

    @ManyToOne
    private Shop shop;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDateTime dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public LocalDateTime getDateOfShipping() {
        return dateOfShipping;
    }

    public void setDateOfShipping(LocalDateTime dateOfShipping) {
        this.dateOfShipping = dateOfShipping;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
