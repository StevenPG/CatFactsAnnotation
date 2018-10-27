package com.stevenpg.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class Application {

    @Autowired
    public ApplicationContext ctx;

    public PrintHi hi = new PrintHi();

    public PrintHi getHiObject() {
        return this.hi;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Application app = new Application();
        System.out.println(app.ctx.getBeanDefinitionNames());

        app.getHiObject().sayHi();
    }
}
