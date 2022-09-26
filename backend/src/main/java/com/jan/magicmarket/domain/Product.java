package com.jan.magicmarket.domain;

import com.jan.magicmarket.config.constants.ProductCategory;

import javax.persistence.*;

@Entity
public class Product extends BaseEntity {

    @Column
    private String name;

    @Column
    private ProductCategory productCategory;

    @Column
    private String description;

    @Column
    private int stock;

    @Column
    private Double price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Card card;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
