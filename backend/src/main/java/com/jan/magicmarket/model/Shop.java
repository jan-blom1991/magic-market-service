package com.jan.magicmarket.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "shop")
@AttributeOverride(name = "id", column = @Column(name = "shop_id"))
public class Shop  extends BaseEntity {

    @Column
    private Double totalRevenue;
}
