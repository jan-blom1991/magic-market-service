package com.jan.MagicWebShop.repositories;

import com.jan.MagicWebShop.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface AddressRepository extends CrudRepository<Address, Long> {

}
