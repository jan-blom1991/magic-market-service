package com.jan.magicmarket.repositories;

import com.jan.magicmarket.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AddressRepository extends CrudRepository<Address, Long> {

}
