package com.jan.magicmarket.services;

import com.jan.magicmarket.domain.Product;
import com.jan.magicmarket.repositories.ImageRepository;
import com.jan.magicmarket.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ImageRepository imageRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Iterable<Product> getProductsByCategory (String category) {
        return productRepository.findByCategory(category);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }
}
