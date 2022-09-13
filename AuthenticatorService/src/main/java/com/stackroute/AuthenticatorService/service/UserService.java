package com.stackroute.AuthenticatorService.service;

import com.stackroute.AuthenticatorService.exception.UserNotFoundException;
import com.stackroute.AuthenticatorService.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void saveUser(User user);
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}
