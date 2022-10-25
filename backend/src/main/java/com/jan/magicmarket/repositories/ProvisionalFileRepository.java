package com.jan.magicmarket.repositories;

import com.jan.magicmarket.domain.ProvisionalFile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProvisionalFileRepository extends CrudRepository<ProvisionalFile, Long> {

    @Query("SELECT coalesce(max(ProvisionalFile.fileGroup), 0) FROM ProvisionalFile")
    Long getMaxFileGroup();
}
