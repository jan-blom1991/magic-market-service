package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.constants.ProductCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/product-categories")
public class ProductCategoryController {

    @GetMapping()
    public String[] getProductCategories() {
        return Arrays.stream(ProductCategory.values()).map(ProductCategory::getValue).toArray(String[]::new);
    }
}
