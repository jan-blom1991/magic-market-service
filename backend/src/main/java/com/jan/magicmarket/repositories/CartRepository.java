package com.jan.magicmarket.repositories;

import com.jan.magicmarket.model.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CartRepository extends CrudRepository<Cart, Long> {
}
