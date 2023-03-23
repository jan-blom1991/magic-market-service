package com.jan.magicmarket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "cart")
@AttributeOverride(name = "id", column = @Column(name = "cart_id"))
public class Cart extends BaseEntity {

    @Column
    private Double subTotal;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItemList = new HashSet<>();
}
