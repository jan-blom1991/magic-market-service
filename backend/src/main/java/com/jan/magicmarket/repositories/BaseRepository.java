package com.jan.magicmarket.repositories;

import com.jan.magicmarket.config.rest.EntityIdentifierException;
import com.jan.magicmarket.config.rest.EntityTokenException;
import com.jan.magicmarket.model.BaseEntity;
import com.jan.magicmarket.model.User;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends PagingAndSortingRepository<T, Long> {

    default T retrieve(Long Id) throws Exception {
        return findById(Id).orElseThrow(EntityIdentifierException::new);
    }

    default T insert(T entity, User user) {
        entity.setTsCreated(LocalDateTime.now());
        entity.setTsChanged(LocalDateTime.now());
        entity.setUserCreated(user);
        entity.setUserChanged(user);

        return save(entity);
    }

    default T update(T entity, User user, LocalDateTime changeToken) throws Exception {
        entity = this.retrieve(entity.getId());

        if (!entity.getTsChanged().equals(changeToken)) {
            throw new EntityTokenException();
        }

        entity.setTsChanged(LocalDateTime.now());
        entity.setUserChanged(user);
        return save(entity);
    }

    default void delete(T entity, LocalDateTime changeToken) throws Exception {
        entity = this.retrieve(entity.getId());

        if (entity.getTsChanged().equals(changeToken)) {
            throw new EntityTokenException();
        }

        delete(entity);
    }
}
