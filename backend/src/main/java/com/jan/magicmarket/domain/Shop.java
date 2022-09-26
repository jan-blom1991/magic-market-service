package com.jan.magicmarket.domain;

import javax.persistence.*;

@Entity
public class Shop  extends BaseEntity {

    @Column private Double totalRevenue;

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
