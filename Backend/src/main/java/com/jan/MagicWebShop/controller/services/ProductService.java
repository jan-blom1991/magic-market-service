package com.jan.MagicWebShop.controller.services;

import com.jan.MagicWebShop.controller.repositories.CartItemRepository;
import com.jan.MagicWebShop.controller.repositories.ProductRepository;
import com.jan.MagicWebShop.controller.repositories.ShoppingCartRepository;
import com.jan.MagicWebShop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository pr;

    @Autowired
    CartItemRepository cir;

    @Autowired
    ShoppingCartRepository scr;

    public Iterable<Product> getAllProducts() {
        return pr.findAll();
    }

    public Iterable<Product> getAllProductsByCategory(String category) {
        return pr.findAllByCategory(category);
    }

    public void addProduct(Product product) {
        pr.save(product);
    }

    public void removeProduct(Long id) {
        pr.deleteById(id);
    }

    public void saveImageToProduct(Long id, MultipartFile file) {
        try {
            Product product = pr.findById(id).get();
            byte[] bytes = file.getBytes();
            product.setImage(bytes);
        }
        catch (IOException e) {
            System.out.println("Uploading file failed");
        }
    }
}