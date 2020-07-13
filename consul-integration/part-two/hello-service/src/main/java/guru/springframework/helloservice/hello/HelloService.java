package guru.springframework.helloservice.hello;

import guru.springframework.helloservice.client.User;
import guru.springframework.helloservice.client.UsersServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {
    
    private final UsersServiceClient client;
    
    String getUserHello() {
        User user = client.getUser();
        
        return "Hello " + user.getName() + " " + user.getSurname() + "!!!";
    }
}
