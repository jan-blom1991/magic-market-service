package com.jan.magicmarket.repositories;

import com.jan.magicmarket.model.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends BaseRepository<User> {

    Optional<User> findByEmailAddress(String emailAddress);
}
