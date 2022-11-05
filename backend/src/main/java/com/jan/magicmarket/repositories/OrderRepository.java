package com.jan.magicmarket.repositories;

import com.jan.magicmarket.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderRepository extends CrudRepository<Order, Long> {
}
