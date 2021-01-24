package com.jan.MagicWebShop.services;

import com.jan.MagicWebShop.repositories.AddressRepository;
import com.jan.MagicWebShop.repositories.PurchaseOrderRepository;
import com.jan.MagicWebShop.repositories.ShoppingCartRepository;
import com.jan.MagicWebShop.repositories.UserRepository;
import com.jan.MagicWebShop.domain.Address;
import com.jan.MagicWebShop.domain.User;
import com.jan.MagicWebShop.domain.Order;
import com.jan.MagicWebShop.domain.ShoppingCart;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    UserRepository userRepository;

    AddressRepository addressRepository;

    PurchaseOrderRepository purchaseOrderRepository;

    ShoppingCartRepository shoppingCartRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }
}