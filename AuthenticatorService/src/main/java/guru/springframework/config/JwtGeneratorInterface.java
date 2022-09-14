package guru.springframework.config;

import guru.springframework.model.User;
import java.util.Map;

public interface JwtGeneratorInterface {

    Map<String, String> generateToken(User user);
}
