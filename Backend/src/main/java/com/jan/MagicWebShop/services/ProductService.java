package com.jan.MagicWebShop.services;

import com.jan.MagicWebShop.repositories.CartItemRepository;
import com.jan.MagicWebShop.repositories.ProductRepository;
import com.jan.MagicWebShop.repositories.ShoppingCartRepository;
import com.jan.MagicWebShop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@Transactional
public class ProductService {

    ProductRepository productRepository;

    CartItemRepository cartItemRepository;

    ShoppingCartRepository shoppingCartRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Iterable<Product> getProductsByCategory (String category) {
        return productRepository.findByCategory(category);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void saveImageToProduct(Long id, MultipartFile file) {
        try {
            Product product = productRepository.findById(id).get();
            byte[] bytes = file.getBytes();
            product.setImage(bytes);
        }
        catch (IOException e) {
            System.out.println("Uploading file failed");
        }
    }
}