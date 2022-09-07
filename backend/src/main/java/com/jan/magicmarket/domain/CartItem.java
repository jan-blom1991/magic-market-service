package com.jan.magicmarket.domain;

import javax.persistence.*;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private int quantity;
    private double itemSubTotal;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemSubTotal() {
        return itemSubTotal;
    }

    public void setItemSubTotal(double itemSubTotal) {
        this.itemSubTotal = itemSubTotal;
    }
}
