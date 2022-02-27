package guru.springframework.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {

    @RequestMapping("/greet")
    public String greetWelcomeMessage(){
        return "Welcome to all the employees !";
    }

}
