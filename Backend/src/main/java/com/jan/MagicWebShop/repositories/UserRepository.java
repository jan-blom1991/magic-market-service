package com.jan.MagicWebShop.repositories;

import com.jan.MagicWebShop.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User, Long> {
}