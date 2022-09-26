package com.jan.magicmarket.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart extends BaseEntity {

    @Column
    private Double subTotal;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItemList;

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Set<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(Set<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }
}
