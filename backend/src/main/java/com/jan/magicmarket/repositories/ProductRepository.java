package com.jan.magicmarket.repositories;

import com.jan.magicmarket.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.data.repository.CrudRepository;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {
}
