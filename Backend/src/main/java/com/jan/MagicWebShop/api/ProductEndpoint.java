package com.jan.MagicWebShop.api;

import com.jan.MagicWebShop.controller.ProductService;
import com.jan.MagicWebShop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ProductEndpoint {

    @Autowired
    ProductService ps;

    @GetMapping("/productlist")
    public Iterable<Product> getAllProducts() {
        System.out.println("Obtaining product list...");
        for (Product product : ps.getAllProducts()) {
            System.out.println(">>> obtaining: " + product.getName());
        }
        return ps.getAllProducts();
    }

    @PostMapping("/addproduct")
    public long addproduct(@RequestBody Product product) {
        System.out.println("Sending new product...");
        ps.addProduct(product);
        System.out.println(">>> sending: " + product.getName());
        return product.getId();
    }

    @PostMapping("/uploadimage/{id}")
    public void addproduct(@PathVariable long id, @RequestParam("file") MultipartFile file) {
        ps.saveImageToProduct(id, file);
        System.out.println(">>> uploading image: " + file.getName());
    }


    @DeleteMapping("/removeproduct/{productId}")
    public void removeProduct(@PathVariable long productId) {
        System.out.println("Deleting product...");
        ps.removeProduct(productId);
        System.out.println(">>> deleting: " + productId);
    }

    @PutMapping("/editproduct")
    public void editProduct(@RequestBody Product product) {
        System.out.println("Editing product...");
        ps.addProduct(product);
        System.out.println(">>> editing: " + product.getName());
    }

    @GetMapping("/boosterboxlist")
    public Iterable<Product> sendAllBoosterBoxess() {
        System.out.println("Obtaining booster pack list...");
        ArrayList<Product> boosterPackList = new ArrayList<>();
        for (Product product : ps.getAllProducts()) {
            if (product.getCategory().equals("Booster box")) {
                boosterPackList.add(product);
                System.out.println(">>> obtaining: " + product.getName());
            }
        }
        return boosterPackList;
    }

    @GetMapping("/boosterpacklist")
    public Iterable<Product> sendAllBoosterPacks() {
        System.out.println("Obtaining booster pack list...");
        ArrayList<Product> boosterPackList = new ArrayList<>();
        for (Product product : ps.getAllProducts()) {
            if (product.getCategory().equals("Booster pack")) {
                boosterPackList.add(product);
                System.out.println(">>> obtaining: " + product.getName());
            }
        }
        return boosterPackList;
    }

    @GetMapping("/fatpacklist")
    public Iterable<Product> sendAllFatPacks() {
        System.out.println("Obtaining fat pack list...");
        ArrayList<Product> fatPackList = new ArrayList<>();
        for (Product product : ps.getAllProducts()) {
            if (product.getCategory().equals("Fat pack")) {
                fatPackList.add(product);
                System.out.println(">>> obtaining: " + product.getName());
            }
        }
        return fatPackList;
    }

    @GetMapping("/starterdecklist")
    public Iterable<Product> sendAllStarterDecks() {
        System.out.println("Obtaining starter deck list...");
        ArrayList<Product> starterDeckList = new ArrayList<>();
        for (Product product : ps.getAllProducts()) {
            if (product.getCategory().equals("Starter deck")) {
                starterDeckList.add(product);
                System.out.println(">>> obtaining: " + product.getName());
            }
        }
        return starterDeckList;
    }
}