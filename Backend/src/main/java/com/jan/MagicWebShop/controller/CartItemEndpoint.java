package com.jan.MagicWebShop.controller;


import com.jan.MagicWebShop.services.CartItemService;
import com.jan.MagicWebShop.domain.CartItem;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart-items")
public class CartItemEndpoint {

    CartItemService cartItemService;

    @GetMapping()
    public Iterable<CartItem> sendAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @PostMapping("/{productId}/{productQuantity}")
    public void addCartItem(@PathVariable long productId, @PathVariable int productQuantity) {
        cartItemService.addCartItem(productId, productQuantity);
    }

    @DeleteMapping("/{cartItemId}")
    public void removeCartItem(@PathVariable long cartItemId) {
        cartItemService.removeCartItem(cartItemId);
    }
}
