package com.jan.magicmarket.repositories;

import com.jan.magicmarket.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmailAddress(String emailAddress);
}
