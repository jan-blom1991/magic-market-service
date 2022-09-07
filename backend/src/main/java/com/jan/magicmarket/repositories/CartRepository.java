package com.jan.magicmarket.repositories;

import com.jan.magicmarket.domain.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CartRepository extends CrudRepository<Cart, Long> {
}
