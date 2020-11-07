package com.jan.MagicWebShop.api;

import com.jan.MagicWebShop.controller.services.ProductService;
import com.jan.MagicWebShop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ProductEndpoint {

    @Autowired
    ProductService ps;

    @GetMapping("/productlist")
    public Iterable<Product> getAllProducts() {
        System.out.println(">>> obtaining product list");
        return ps.getAllProducts();
    }

    @PostMapping("/addproduct")
    public long addproduct(@RequestBody Product product) {
        System.out.println(">>> adding new product");
        ps.addProduct(product);
        return product.getId();
    }

    @PostMapping("/uploadimage/{id}")
    public void addproduct(@PathVariable long id, @RequestParam("file") MultipartFile file) {
        System.out.println(">>> uploading image");
        ps.saveImageToProduct(id, file);
    }


    @DeleteMapping("/removeproduct/{productId}")
    public void removeProduct(@PathVariable long productId) {
        System.out.println(">>> deleting product");
        ps.removeProduct(productId);
    }

    @PutMapping("/editproduct")
    public void editProduct(@RequestBody Product product) {
        System.out.println(">>> editing product");
        ps.addProduct(product);
    }

    @GetMapping("/boosterboxlist")
    public Iterable<Product> sendAllBoosterBoxess() {
        System.out.println(">>> obtaining booster box list");
        return ps.getAllProductsByCategory("booster box");
    }

    @GetMapping("/boosterpacklist")
    public Iterable<Product> sendAllBoosterPacks() {
        System.out.println(">>> obtaining booster pack list");
        return ps.getAllProductsByCategory("booster pack");
    }

    @GetMapping("/fatpacklist")
    public Iterable<Product> sendAllFatPacks() {
        System.out.println(">>> obtaining fat pack list.");
        return ps.getAllProductsByCategory("fat pack");
    }

    @GetMapping("/starterdecklist")
    public Iterable<Product> sendAllStarterDecks() {
        System.out.println(">>> obtaining starter deck list");
        return ps.getAllProductsByCategory("starter deck");
    }
}