package com.jan.MagicWebShop.services;

import com.jan.MagicWebShop.repositories.CartItemRepository;
import com.jan.MagicWebShop.repositories.ProductRepository;
import com.jan.MagicWebShop.repositories.ShoppingCartRepository;
import com.jan.MagicWebShop.domain.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class CartItemService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    public Iterable<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void removeCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    public void addCartItem(long productId, int productQuantity) {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(productRepository.findById(productId).get());
        cartItem.setQuantity(productQuantity);
        cartItem.setItemSubTotal(productRepository.findById(productId).get().getPrice()*productQuantity);
        cartItem.setShoppingCart(shoppingCartRepository.findById((long)55).get());
        cartItemRepository.save(cartItem);
    }
}
