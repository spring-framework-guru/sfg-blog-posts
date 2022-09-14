package guru.springframework.service;

import guru.springframework.exception.UserNotFoundException;
import guru.springframework.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void saveUser(User user);
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}
