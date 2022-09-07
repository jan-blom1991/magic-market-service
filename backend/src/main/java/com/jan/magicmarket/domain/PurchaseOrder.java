package com.jan.magicmarket.domain;

import com.jan.magicmarket.config.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long purchaseOrderId;

    private LocalDateTime dateOfOrder;
    private LocalDateTime dateOfShipping;
    private OrderStatus orderStatus;

    @OneToOne
    @MapsId
    private Cart cart;

    public long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
