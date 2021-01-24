package com.jan.MagicWebShop.controller;

import com.jan.MagicWebShop.services.ProductService;
import com.jan.MagicWebShop.domain.Product;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/products")
public class ProductEndpoint {

    ProductService productService;

    @GetMapping()
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/addproduct")
    public long addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return product.getId();
    }

    @PostMapping("/uploadimage/{id}")
    public void addProduct(@PathVariable long id, @RequestParam("file") MultipartFile file) {
        productService.saveImageToProduct(id, file);
    }


    @DeleteMapping("/removeproduct/{productId}")
    public void removeProduct(@PathVariable long productId) {
        productService.removeProduct(productId);
    }

    @PutMapping("/{productId}")
    public void editProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @GetMapping("/?category={productCategory}")
    public Iterable<Product> getProductsByCategory(@PathVariable String productCategory) {
        return productService.getProductsByCategory(productCategory);
    }
}