package com.stevenpg.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
