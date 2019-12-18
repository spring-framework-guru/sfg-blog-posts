package guru.springframework.dibestpractices.controllers;

import guru.springframework.dibestpractices.services.MyService;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/7/19.
 */
@Controller
public class ConstructorController {
    private MyService myService;

    public ConstructorController(MyService myService) {
        this.myService = myService;
    }

    public String saySomething(){
        return myService.getHello();
    }
}
