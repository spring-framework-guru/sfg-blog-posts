package guru.springframework.springfilter.controller;

import guru.springframework.springfilter.domain.MemeMaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meme")
public class MemeController {
    @GetMapping
    @ResponseBody
    public MemeMaker getMemeMakerDetails() {
        MemeMaker memeMaker = new MemeMaker();
        memeMaker.setMemeId(1);
        memeMaker.setMemeMaker("Alex");
        memeMaker.setMemeLevel("Noobie");
        memeMaker.setMemeTopic("Trending");
        return memeMaker;
    }
}
