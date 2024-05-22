package org.example.api.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DefaultRestApi {

    @RequestMapping("/welcome")
    public String printWelcome() {
        return "Welcome from default REST api";
    }
}
