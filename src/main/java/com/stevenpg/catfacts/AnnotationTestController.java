package com.stevenpg.catfacts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnnotationTestController {

    @CatFacts
    @GetMapping("/")
    public String catFactsMappingTest() {
        return "Successfully Accessed /";
    }
}
