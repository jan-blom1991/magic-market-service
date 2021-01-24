package com.jan.MagicWebShop.repositories;

import com.jan.MagicWebShop.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PurchaseOrderRepository extends CrudRepository<Order, Long> {
    //1 via erfrelatie
    //2 via methodenamen met gereserveerde woorden icm fieldnamen
    //3 via @Query annotatie (JPQL of SQL native)
}
