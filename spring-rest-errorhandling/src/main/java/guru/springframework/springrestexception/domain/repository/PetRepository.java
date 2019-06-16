package guru.springframework.springrestexception.domain.repository;

import guru.springframework.springrestexception.domain.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

}
