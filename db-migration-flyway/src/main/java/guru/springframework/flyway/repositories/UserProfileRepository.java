package guru.springframework.flyway.repositories;

import guru.springframework.flyway.domain.UserProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile,Long> {
}
