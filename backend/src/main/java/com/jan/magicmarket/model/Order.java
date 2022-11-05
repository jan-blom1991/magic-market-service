package com.jan.magicmarket.model;

import com.jan.magicmarket.config.constants.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "order")
@AttributeOverride(name = "id", column = @Column(name = "order_id"))
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

    @JoinColumn(name = "cart_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Cart cart;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
