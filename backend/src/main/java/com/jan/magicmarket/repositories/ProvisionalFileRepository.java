package com.jan.magicmarket.repositories;

import com.jan.magicmarket.domain.ProvisionalFile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProvisionalFileRepository extends CrudRepository<ProvisionalFile, Long> {

    List<ProvisionalFile> findByFileGroupCode(Long fileGroupCode);
}
