package com.jan.MagicWebShop.controller.services;

import com.jan.MagicWebShop.controller.repositories.AddressRepository;
import com.jan.MagicWebShop.controller.repositories.PurchaseOrderRepository;
import com.jan.MagicWebShop.controller.repositories.ShoppingCartRepository;
import com.jan.MagicWebShop.controller.repositories.UserRepository;
import com.jan.MagicWebShop.domain.Address;
import com.jan.MagicWebShop.domain.User;
import com.jan.MagicWebShop.domain.PurchaseOrder;
import com.jan.MagicWebShop.domain.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository ur;

    @Autowired
    AddressRepository ar;

    @Autowired
    PurchaseOrderRepository por;

    @Autowired
    ShoppingCartRepository scr;

    public void addUser(User user, long addressId, long shoppingCartId, long purchaseOrderId) {
        Optional<Address> optionalAddress = ar.findById(addressId);
        Address address = optionalAddress.get();
        user.setAddress(address);
        Optional<ShoppingCart> optionalShoppingCart = scr.findById(shoppingCartId);
        ShoppingCart shoppingCart = optionalShoppingCart.get();
        user.setShoppingCart(shoppingCart);
        Optional<PurchaseOrder> optionalPurchaseOrder = por.findById(purchaseOrderId);
        PurchaseOrder purchaseOrder = optionalPurchaseOrder.get();
        user.setPurchaseOrder(purchaseOrder);
        ur.save(user);
    }

    public void addAddress(Address address) {
        ar.save(address);
    }

    public void addShoppingCart(ShoppingCart shoppingCart) {
        scr.save(shoppingCart);
    }

    public void addPurchaseOrder(PurchaseOrder purchaseOrder) {
        por.save(purchaseOrder);
    }
}
