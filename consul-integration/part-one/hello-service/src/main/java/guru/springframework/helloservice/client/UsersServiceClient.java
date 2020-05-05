package guru.springframework.helloservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "users-service", url = "http://localhost:8081")
public interface UsersServiceClient {

    @RequestMapping("/user")
    User getUser();
}
