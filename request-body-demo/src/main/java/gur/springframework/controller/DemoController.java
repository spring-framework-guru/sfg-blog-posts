package gur.springframework.controller;

import gur.springframework.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("api/v1")
@RestController
public class DemoController {

    @PostMapping("users")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUserCredential(@RequestBody User user){
        System.out.println("User ID: "+user.getUserName());
        System.out.println("User ID: "+user.getPassword());
        return user;
    }

    @PostMapping("/map/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, String> registerUserCredentialThroughMap(@RequestBody Map<String, String> userMap){
        System.out.println("User ID: "+userMap.get("userName"));
        System.out.println("Password: "+userMap.get("password"));
        return userMap;
    }
}
