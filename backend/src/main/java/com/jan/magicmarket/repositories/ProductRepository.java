package com.jan.magicmarket.repositories;

import com.jan.magicmarket.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
