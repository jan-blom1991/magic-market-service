package com.jan.magicmarket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jan.magicmarket.config.constants.ProductCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "product")
@AttributeOverride(name = "id", column = @Column(name = "product_id"))
public class Product extends BaseEntity {

    @Column
    private String name;

    @Column
    private ProductCategory category;

    @Column
    private String description;

    @Column
    private int stock;

    @Column
    private Double price;

    @JoinColumn(name = "card_id")
    @OneToOne(fetch = FetchType.EAGER)
    private Card card;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProductFile> files = new HashSet<>();

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long fileGroupCode;
}
