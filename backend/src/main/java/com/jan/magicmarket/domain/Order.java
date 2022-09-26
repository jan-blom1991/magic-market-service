package com.jan.magicmarket.domain;

import com.jan.magicmarket.config.constants.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Order extends BaseEntity {

    @Column
    private Double shippingCost;

    @Column
    private Double totalCost;

    @Column
    private LocalDateTime dateOfOrder;

    @Column
    private LocalDateTime dateOfShipping;

    @Column
    private OrderStatus orderStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    public Double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
