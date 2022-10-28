package com.jan.magicmarket.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductFile extends File {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
