package guru.springframework.dockercompose.controller;

import guru.springframework.dockercompose.domain.User;
import guru.springframework.dockercompose.exception.UserAlreadyExistsException;
import guru.springframework.dockercompose.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * RestController annotation is used to create
 * Restful web services using Spring MVC
 */
@RestController

/**
 * RequestMapping annotation maps
 * HTTP requests to handler methods
 */
@RequestMapping(value = "/api/v1/")
public class UserController {
    private UserService userService;
    ResponseEntity responseEntity;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * PostMapping Annotation for mapping HTTP POST requests onto
     * specific handler methods.
     */
    @PostMapping("user")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException, Exception {
        User savedUser = userService.saveUser(user);
        responseEntity = new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
        return responseEntity;
    }
}
