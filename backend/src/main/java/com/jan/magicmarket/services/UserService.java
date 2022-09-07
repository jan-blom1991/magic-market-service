package com.jan.magicmarket.services;

import com.jan.magicmarket.repositories.AddressRepository;
import com.jan.magicmarket.repositories.OrderRepository;
import com.jan.magicmarket.repositories.CartRepository;
import com.jan.magicmarket.repositories.UserRepository;
import com.jan.magicmarket.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartRepository cartRepository;

    public Optional<User> getUser(String emailAddress) {
        return userRepository.findByEmailAddress(emailAddress);
    }

    public void addUser(User user) {
        userRepository.save(user);
    }
}
