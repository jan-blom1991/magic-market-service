package com.jan.MagicWebShop.controller;

import com.jan.MagicWebShop.domain.Product;
import org.springframework.stereotype.Component;
import org.springframework.data.repository.CrudRepository;

@Component
public interface ProductRepository extends CrudRepository<Product, Long> {
    //1 via erfrelatie
    //2 via methodenamen met gereserveerde woorden icm fieldnamen
    //3 via @Query annotatie (JPQL of SQL native)
}