package com.jan.magicmarket.repositories;

import com.jan.magicmarket.domain.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ImageRepository extends CrudRepository<Image, Long> {
}
