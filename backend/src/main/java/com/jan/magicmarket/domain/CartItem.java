package com.jan.magicmarket.domain;

import javax.persistence.*;

@Entity
public class CartItem extends BaseEntity {

    @Column
    private Integer quantity;

    @Column
    private Double itemSubTotal;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Cart cart;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getItemSubTotal() {
        return itemSubTotal;
    }

    public void setItemSubTotal(Double itemSubTotal) {
        this.itemSubTotal = itemSubTotal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
