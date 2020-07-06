package guru.springframework.helloservice.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService service;

    @GetMapping("/hello")
    String getUserHello() {
        return service.getUserHello();
    }
}
