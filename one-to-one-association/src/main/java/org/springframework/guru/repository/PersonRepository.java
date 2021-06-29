package org.springframework.guru.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.guru.domain.Person;

public interface PersonRepository extends CrudRepository<Person,Long> {
}
