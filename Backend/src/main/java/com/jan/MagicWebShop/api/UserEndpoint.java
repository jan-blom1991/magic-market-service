package com.jan.MagicWebShop.api;

import com.jan.MagicWebShop.controller.UserService;
import com.jan.MagicWebShop.domain.Address;
import com.jan.MagicWebShop.domain.User;
import com.jan.MagicWebShop.domain.PurchaseOrder;
import com.jan.MagicWebShop.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserEndpoint {

    @Autowired
    UserService us;

    @PostMapping("/adduser/{addressId}/{shoppingCartId}/{purchaseOrderId}")
    public void addUser(@RequestBody User user, @PathVariable long addressId, @PathVariable long shoppingCartId, @PathVariable long purchaseOrderId) {
        System.out.println("Sending new user...");
        us.addUser(user, addressId, shoppingCartId, purchaseOrderId);
        System.out.println(">>> sending: " + user.getName());
    }

    @PostMapping("/addaddress")
    public Address addAddress(@RequestBody Address address) {
        System.out.println("Sending new address...");
        us.addAddress(address);
        System.out.println(">>> sending id: " + address.getId());
        return address;
    }

    @PostMapping("/addshoppingcart")
    public ShoppingCart addShoppingCart(@RequestBody ShoppingCart shoppingCart) {
        System.out.println("Sending new shopping cart...");
        us.addShoppingCart(shoppingCart);
        System.out.println(">>> sending id: " + shoppingCart.getId());
        return shoppingCart;
    }

    @PostMapping("/addpurchaseorder")
    public PurchaseOrder addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        System.out.println("Sending new purchase order...");
        us.addPurchaseOrder(purchaseOrder);
        System.out.println(">>> sending id: " + purchaseOrder.getId());
        return purchaseOrder;
    }

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }
}

