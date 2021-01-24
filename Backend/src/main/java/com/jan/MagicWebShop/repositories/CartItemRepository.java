package com.jan.MagicWebShop.repositories;

import com.jan.MagicWebShop.domain.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}
