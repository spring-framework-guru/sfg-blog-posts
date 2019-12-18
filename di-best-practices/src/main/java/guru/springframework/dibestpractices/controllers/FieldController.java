package guru.springframework.dibestpractices.controllers;

import guru.springframework.dibestpractices.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/7/19.
 */
@Controller
public class FieldController {

    @Autowired
    MyService myService;

    public String saySomething(){
        return myService.getHello();
    }
}
