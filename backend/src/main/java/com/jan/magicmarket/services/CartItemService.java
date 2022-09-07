package com.jan.magicmarket.services;

import com.jan.magicmarket.repositories.CartItemRepository;
import com.jan.magicmarket.repositories.ProductRepository;
import com.jan.magicmarket.repositories.CartRepository;
import com.jan.magicmarket.domain.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartItemService {

    ProductRepository productRepository;

    CartItemRepository cartItemRepository;

    CartRepository cartRepository;

    public Iterable<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void removeCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    public void addCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }
}
