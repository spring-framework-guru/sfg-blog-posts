package guru.springframework.dockercompose.service;

import guru.springframework.dockercompose.domain.User;
import guru.springframework.dockercompose.exception.UserAlreadyExistsException;

public interface UserService {

    /**
     * AbstractMethod to save a user
     */
    public User saveUser(User user) throws UserAlreadyExistsException;

}
