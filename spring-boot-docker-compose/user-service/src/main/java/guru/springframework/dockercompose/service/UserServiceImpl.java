package guru.springframework.dockercompose.service;

import guru.springframework.dockercompose.domain.User;
import guru.springframework.dockercompose.exception.UserAlreadyExistsException;
import guru.springframework.dockercompose.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Service indicates annotated class is a service which
 * holds business logic in the Service layer
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    /*
     * to get property value
     */
    @Value("${app.exceptionMessage}")
    private String exceptionMessage;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * save a user in dockerized mongo container
     */
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        /*
         * Implementation of saveBlog method
         * Throw UserAlreadyExistsException if user id already exists in db
         */
        if (userRepository.existsById(user.getId())) {
            throw new UserAlreadyExistsException(exceptionMessage);
        } else
            return userRepository.save(user);
    }
}
