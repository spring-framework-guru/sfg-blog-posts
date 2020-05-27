package guru.springframework.usersservice.users;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class UserController {

    private final UserProperties properties;

    @GetMapping("/user")
    User getUser() {
        return new User(properties.getName(), properties.getSurname());
    }
}
