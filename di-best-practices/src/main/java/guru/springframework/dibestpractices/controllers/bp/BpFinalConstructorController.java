package guru.springframework.dibestpractices.controllers.bp;

import guru.springframework.dibestpractices.services.bp.BpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/7/19.
 */
@RequiredArgsConstructor
@Controller
public class BpFinalConstructorController {
    private final BpService bpService;

    public String saySomething(){
        return bpService.getHello();
    }
}
