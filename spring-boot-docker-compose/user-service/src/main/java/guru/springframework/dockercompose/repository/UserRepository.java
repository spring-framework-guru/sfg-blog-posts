package guru.springframework.dockercompose.repository;

import guru.springframework.dockercompose.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Repository marks the specific class as a Data Access Object
 */
@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
}
