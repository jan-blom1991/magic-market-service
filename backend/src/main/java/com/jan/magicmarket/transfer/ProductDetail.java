package com.jan.magicmarket.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jan.magicmarket.config.constants.ProductCategory;
import com.jan.magicmarket.model.ProductFile;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDetail {

    private final Long id;
    private final String name;
    private final ProductCategory category;
    private final String description;
    private final Integer stock;
    private final Double price;
    private final Set<ProductFile> files;
}
