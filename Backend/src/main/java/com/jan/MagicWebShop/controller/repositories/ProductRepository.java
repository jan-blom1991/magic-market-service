package com.jan.MagicWebShop.controller.repositories;

import com.jan.MagicWebShop.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.data.repository.CrudRepository;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findAllByCategory(String category);
}