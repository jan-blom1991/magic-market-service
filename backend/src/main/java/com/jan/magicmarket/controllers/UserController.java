package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.rest.ResponseObject;
import com.jan.magicmarket.model.User;
import com.jan.magicmarket.services.UserService;
import com.jan.magicmarket.transfer.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @GetMapping("/{emailAddress}")
    public ResponseEntity<?> getUser(@PathVariable String emailAddress,
                                     @RequestParam String password,
                                     HttpServletRequest request) {

        ResponseObject<UserDetail> responseObject  = userService.getUser(emailAddress, password);
        return generateResponse(responseObject, request);
    }

    @PostMapping()
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
