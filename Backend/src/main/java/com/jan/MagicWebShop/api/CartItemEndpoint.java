package com.jan.MagicWebShop.api;


import com.jan.MagicWebShop.controller.CartItemService;
import com.jan.MagicWebShop.domain.CartItem;
import com.jan.MagicWebShop.domain.Product;
import com.jan.MagicWebShop.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class CartItemEndpoint {

    @Autowired
    CartItemService cis;

    @PostMapping("/addcartitem/{productId}/{productQuantity}")
    public void addCartItem(@PathVariable long productId, @PathVariable int productQuantity) {
        System.out.println("Sending new product to cart item...");
        cis.addCartItem(productId, productQuantity);
        System.out.println(">>> sending: " + productId);
    }

    @GetMapping("/cartitemlist")
    public Iterable<CartItem> sendAllCartItems() {
        System.out.println("Obtaining cart item list...");
        for (CartItem cartItem : cis.getAllCartItems()) {
            if (true) {
                System.out.println(">>> obtaining id: " + cartItem.getId());
            }
        }
        return cis.getAllCartItems();
    }

    @DeleteMapping("/removecartitem/{cartItemId}")
    public void removeCartItem(@PathVariable long cartItemId) {
        System.out.println("Deleting cart item...");
        cis.removeCartItem(cartItemId);
        System.out.println(">>> deleting id: " + cartItemId);
    }
}
