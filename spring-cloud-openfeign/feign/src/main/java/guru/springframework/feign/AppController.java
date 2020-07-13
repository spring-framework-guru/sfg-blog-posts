package guru.springframework.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final SimpleClient client;
    
    @GetMapping("/data/{id}")
    public SimpleClientData getData(@PathVariable int id) {
        return client.getData(id);
    }
}
