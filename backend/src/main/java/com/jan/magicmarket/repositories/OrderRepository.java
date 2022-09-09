package com.jan.magicmarket.repositories;

import com.jan.magicmarket.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderRepository extends CrudRepository<Order, Long> {
}
