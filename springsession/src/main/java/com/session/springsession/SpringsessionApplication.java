package com.session.springsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 */
@SpringBootApplication
public class SpringsessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringsessionApplication.class, args);
    }

    @RestController
    @RequestMapping
    class Test {
        @GetMapping("/session")
        public String session(HttpServletRequest request) {
            return "session: " + request.getSession().getId() + "  port: " + request.getServerPort();
        }
    }
}
