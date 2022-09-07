package com.jan.magicmarket.repositories;

import com.jan.magicmarket.domain.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderRepository extends CrudRepository<PurchaseOrder, Long> {
}
