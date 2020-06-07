package guru.springframework.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simple-client", url = "http://localhost:8081")
public interface SimpleClient {

    @GetMapping("/data/{dataId}")
    SimpleClientData getData(@PathVariable int dataId);
}