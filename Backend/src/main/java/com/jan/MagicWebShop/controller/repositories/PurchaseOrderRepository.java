package com.jan.MagicWebShop.controller.repositories;

import com.jan.MagicWebShop.domain.Product;
import com.jan.MagicWebShop.domain.PurchaseOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Long> {
    //1 via erfrelatie
    //2 via methodenamen met gereserveerde woorden icm fieldnamen
    //3 via @Query annotatie (JPQL of SQL native)
}
