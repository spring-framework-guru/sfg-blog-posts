package guru.springframework.simpleclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleClientController {

    @GetMapping("/data/{dataId}")
    public SimpleClientData getData(@PathVariable int dataId) {
        return new SimpleClientData(dataId, "name-" + dataId, dataId * 2);
    }
}
