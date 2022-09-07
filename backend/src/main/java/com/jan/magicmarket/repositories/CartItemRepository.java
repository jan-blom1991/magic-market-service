package com.jan.magicmarket.repositories;

import com.jan.magicmarket.domain.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}
