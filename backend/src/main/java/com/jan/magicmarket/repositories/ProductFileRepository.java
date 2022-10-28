package com.jan.magicmarket.repositories;

import com.jan.magicmarket.domain.ProductFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductFileRepository extends CrudRepository<ProductFile, Long> {
}
