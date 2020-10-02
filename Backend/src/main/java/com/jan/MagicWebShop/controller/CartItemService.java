package com.jan.MagicWebShop.controller;

import com.jan.MagicWebShop.domain.CartItem;
import com.jan.MagicWebShop.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CartItemService {

    @Autowired
    ProductRepository pr;

    @Autowired
    CartItemRepository cir;

    @Autowired
    ShoppingCartRepository scr;

    public Iterable<CartItem> getAllCartItems() {
        return cir.findAll();
    }

    public void removeCartItem(Long id) {
        cir.deleteById(id);
    }

    public void addCartItem(long productId, int productQuantity) {
        CartItem cartItem = new CartItem();
        cartItem.setProduct(pr.findById(productId).get());
        cartItem.setQuantity(productQuantity);
        cartItem.setItemSubTotal(pr.findById(productId).get().getPrice()*productQuantity);
        cartItem.setShoppingCart(scr.findById((long)55).get());
        cir.save(cartItem);
    }
}
