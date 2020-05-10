package guru.springframework.usersservice.users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

    @GetMapping("/user")
    User getUser() {
        return new User("Spring", "Guru");
    }
}
