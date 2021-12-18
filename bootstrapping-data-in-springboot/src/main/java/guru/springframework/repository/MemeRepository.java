package guru.springframework.repository;

import guru.springframework.model.MemeMaker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemeRepository extends CrudRepository<MemeMaker, Integer> {

}

