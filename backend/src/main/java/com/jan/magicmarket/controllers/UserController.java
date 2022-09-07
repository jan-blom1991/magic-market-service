package com.jan.magicmarket.controllers;

import com.jan.magicmarket.services.UserService;
import com.jan.magicmarket.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public Optional<User> getUser(@RequestParam String emailAddress) {
        return userService.getUser(emailAddress);
    }

    @PostMapping()
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
