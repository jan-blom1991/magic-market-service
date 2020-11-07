package com.jan.MagicWebShop.api;


import com.jan.MagicWebShop.controller.services.CartItemService;
import com.jan.MagicWebShop.domain.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartItemEndpoint {

    @Autowired
    CartItemService cis;

    @PostMapping("/addcartitem/{productId}/{productQuantity}")
    public void addCartItem(@PathVariable long productId, @PathVariable int productQuantity) {
        System.out.println(">>> adding new product to cart item");
        cis.addCartItem(productId, productQuantity);
    }

    @GetMapping("/cartitemlist")
    public Iterable<CartItem> sendAllCartItems() {
        System.out.println(">>> obtaining cart item list");
        return cis.getAllCartItems();
    }

    @DeleteMapping("/removecartitem/{cartItemId}")
    public void removeCartItem(@PathVariable long cartItemId) {
        System.out.println(">>> deleting cart item");
        cis.removeCartItem(cartItemId);
    }
}
