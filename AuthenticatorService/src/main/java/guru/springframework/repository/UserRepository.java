package guru.springframework.repository;

import guru.springframework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public User findByUserNameAndPassword(String userName, String password);
}
