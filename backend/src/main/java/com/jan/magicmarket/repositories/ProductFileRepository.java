package com.jan.magicmarket.repositories;

import com.jan.magicmarket.model.ProductFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface ProductFileRepository extends CrudRepository<ProductFile, Long> {

    Iterable<ProductFile> findAllByProductIdOrderByOrder(Long productId);

    Optional<ProductFile> findByProductIdAndOrder(Long productId, Integer order);
}
