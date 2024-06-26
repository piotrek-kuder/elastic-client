package org.course.practicaljava.api.server;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
@RequestMapping("/api")
public class DefaultRestApi {
    private static final Logger LOG = LoggerFactory.getLogger(DefaultRestApi.class);

    @GetMapping("/welcome")
    public String printWelcome() {
        String joinMessage = StringUtils.join("This is", " joined", " text");
        LOG.info(joinMessage);
        return "Welcome from default REST api";
    }

    @GetMapping("/time")
    public String time() {
        return LocalTime.now().toString();
    }
}
