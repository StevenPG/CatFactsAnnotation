package com.stevenpg.aop;

import org.springframework.stereotype.Component;

@Component
public class PrintHi {

    @CatFacts
    public void sayHi() {
        System.out.println("Hi");
    }
}
