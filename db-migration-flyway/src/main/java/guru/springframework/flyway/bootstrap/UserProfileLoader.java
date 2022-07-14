package guru.springframework.flyway.bootstrap;

import guru.springframework.flyway.domain.UserProfile;
import guru.springframework.flyway.repositories.UserProfileRepository;
import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserProfileLoader implements CommandLineRunner {

    private final UserProfileRepository userProfileRepository;

    public UserProfileLoader(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        userProfileRepository.deleteAll();

        UserProfile userProfileEJ = new UserProfile("Eric Johnson", "Oklahoma City", "Male");
        UserProfile savedEJ = userProfileRepository.save(userProfileEJ);

        UserProfile userProfileAS = new UserProfile("Andy Smith", "New York City","Male");
        UserProfile savedAS = userProfileRepository.save(userProfileAS);

        userProfileRepository.findAll().forEach(user -> {
            System.out.println("Name: " + user.getName());
            System.out.println("City: " + user.getCity());
        });
    }
}
