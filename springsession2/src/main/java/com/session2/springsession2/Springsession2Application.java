package com.session2.springsession2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@SpringBootApplication
@MapperScan("com.session2.springsession2.mapper")
public class Springsession2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springsession2Application.class, args);
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
