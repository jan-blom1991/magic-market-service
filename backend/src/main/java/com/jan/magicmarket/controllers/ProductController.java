package com.jan.magicmarket.controllers;

import com.jan.magicmarket.services.ProductService;
import com.jan.magicmarket.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping()
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping()
    public void editProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @DeleteMapping("/{productId}")
    public void removeProduct(@PathVariable Long productId) {
        productService.removeProduct(productId);
    }

//    @GetMapping("/?category={productCategory}")
//    public Iterable<Product> getProductsByCategory(@PathVariable String productCategory) {
//        return productService.getProductsByCategory(productCategory);
//    }
}
