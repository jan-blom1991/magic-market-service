package com.jan.magicmarket.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jan.magicmarket.config.constants.ProductCategory;
import com.jan.magicmarket.model.File;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductOverview {

    private final Integer index;
    private final Long id;
    private final String name;
    private final ProductCategory category;
    private final Integer stock;
    private final Double price;
    private final File file;
}
