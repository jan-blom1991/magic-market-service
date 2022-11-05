package com.jan.magicmarket.repositories;

import com.jan.magicmarket.model.ProvisionalFile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProvisionalFileRepository extends CrudRepository<ProvisionalFile, Long> {

    List<ProvisionalFile> findByFileGroupCode(Long fileGroupCode);

    @Query("SELECT max(u.order) FROM ProvisionalFile u WHERE u.fileGroupCode = :fileGroupCode")
    Integer findMaxOrderByFileGroupCode(Long fileGroupCode);
}
