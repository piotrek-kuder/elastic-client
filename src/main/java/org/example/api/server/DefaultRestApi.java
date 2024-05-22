package org.example.api.server;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/api")
public class DefaultRestApi {

    @GetMapping("/welcome")
    public String printWelcome() {
        String joinMessage = StringUtils.join("This is", " joined", " text");
        System.out.println(joinMessage);
        return "Welcome from default REST api";
    }

    @GetMapping("/time")
    public String time() {
        return LocalTime.now().toString();
    }
}
