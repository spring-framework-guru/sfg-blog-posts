package org.springframework.guru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.guru.domain.Address;

public interface AddressRepository extends CrudRepository<Address,Long> {
}
