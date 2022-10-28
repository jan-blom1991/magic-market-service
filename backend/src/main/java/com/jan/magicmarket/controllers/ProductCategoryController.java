package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.constants.ProductCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-categories")
public class ProductCategoryController {

    @GetMapping()
    public ProductCategory[] getProductCategories() {
        return ProductCategory.values();
    }
}
