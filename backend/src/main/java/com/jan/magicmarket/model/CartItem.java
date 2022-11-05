package com.jan.magicmarket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cart_item")
@AttributeOverride(name = "id", column = @Column(name = "cart_item_id"))
public class CartItem extends BaseEntity {

    @Column
    private Integer quantity;

    @Column
    private Double itemSubTotal;

    @JoinColumn(name = "product_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Product product;

    @JoinColumn(name = "cart_id")
    @ManyToOne(fetch = FetchType.LAZY)
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
