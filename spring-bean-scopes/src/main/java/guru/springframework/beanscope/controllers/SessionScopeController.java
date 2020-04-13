package guru.springframework.beanscope.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@RestController
@SessionScope
public class SessionScopeController {

    @GetMapping("/session/message")
    public String getMessage() {
        return "Hello from SessionScopeController";
    }
}
