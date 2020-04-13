package guru.springframework.beanscope.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
public class RequestScopeController {

    @GetMapping("message")
    public String getMessage() {
        return "Hello from RequestScopeController";
    }
}
