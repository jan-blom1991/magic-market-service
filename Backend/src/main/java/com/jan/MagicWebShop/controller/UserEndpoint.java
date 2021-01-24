package com.jan.MagicWebShop.controller;

import com.jan.MagicWebShop.services.UserService;
import com.jan.MagicWebShop.domain.Address;
import com.jan.MagicWebShop.domain.User;
import com.jan.MagicWebShop.domain.Order;
import com.jan.MagicWebShop.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserEndpoint {

    UserService userService;

    @PostMapping("/{addressId}/{shoppingCartId}/{purchaseOrderId}")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}

