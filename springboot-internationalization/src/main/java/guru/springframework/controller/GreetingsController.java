package guru.springframework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/api")
public class GreetingsController {

    @Autowired
    private ResourceBundleMessageSource source;
    @Value("${placeholder.greetings}")
    private String greetings;

    @GetMapping("/get-message")
    public String getLocaleMessage(
            @RequestHeader(name = "Accept-Language", required = false) final Locale locale,
            @RequestParam(name = "username", defaultValue = "Albert Xin", required = false) final String username) {

        log.info("Returning greetings for locale = {}", locale);
        return source.getMessage(greetings, new Object[]{username}, locale);
    }
}
