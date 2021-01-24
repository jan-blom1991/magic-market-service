package com.jan.MagicWebShop.repositories;

import com.jan.MagicWebShop.domain.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
