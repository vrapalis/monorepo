package com.vrapalis.www.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.vrapalis.www.*")
public class ChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }

}

@RestController
@RequestMapping("/api/greeting")
class GreetingController {
    @GetMapping
    String greeting() {
        return "Hello World";
    }

    @GetMapping("/admin")
    String admin() {
        return "Only accessible by admin";
    }

    @GetMapping("/user")
    String user() {
        return "Only accessible by user";
    }
}
