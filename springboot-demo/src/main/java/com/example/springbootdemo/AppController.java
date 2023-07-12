package com.example.springbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {

    private static Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @GetMapping("/hello")
    public String getHello(){
        LOGGER.info("Executing getHello");
        return "Hello from the other side "+Thread.currentThread().getName();
    }
@GetMapping("/person")
    public Person getPerson(){
    LOGGER.info("Executing getPerson");
        return new Person("Santosh", 25);
    }
}
