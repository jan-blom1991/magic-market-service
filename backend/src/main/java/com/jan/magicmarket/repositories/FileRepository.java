package com.jan.magicmarket.repositories;

import com.jan.magicmarket.domain.File;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface FileRepository extends CrudRepository<File, Long> {
}
