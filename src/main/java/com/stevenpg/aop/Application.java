package com.stevenpg.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class Application {

    public PrintHi hi = new PrintHi();

    public PrintHi getHiObject() {
        return this.hi;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Application app = new Application();
        app.getHiObject().sayHi();
    }
}
