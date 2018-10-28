package com.stevenpg.aop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DummyController {

    @CatFacts
    @RequestMapping("/")
    public String hello() {
        return "helloworld";
    }
}
