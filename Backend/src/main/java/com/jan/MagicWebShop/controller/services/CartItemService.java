package com.jan.MagicWebShop.controller.services;

import com.jan.MagicWebShop.controller.repositories.CartItemRepository;
import com.jan.MagicWebShop.controller.repositories.ProductRepository;
import com.jan.MagicWebShop.controller.repositories.ShoppingCartRepository;
import com.jan.MagicWebShop.domain.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
