package com.jan.magicmarket.controllers;


import com.jan.magicmarket.services.CartItemService;
import com.jan.magicmarket.domain.CartItem;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    CartItemService cartItemService;

    @GetMapping()
    public Iterable<CartItem> sendAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @PostMapping()
    public void addCartItem(@RequestBody CartItem cartItem) {
        cartItemService.addCartItem(cartItem);
    }

    @DeleteMapping("/{cartItemId}")
    public void removeCartItem(@PathVariable long cartItemId) {
        cartItemService.removeCartItem(cartItemId);
    }
}
