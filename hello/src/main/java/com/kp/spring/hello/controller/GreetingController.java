package com.kp.spring.hello.controller;

import com.kp.spring.hello.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String TEMPLATE_STR = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting getGreeting(@RequestParam(value = "content", defaultValue = "world") String content) {
        Greeting greeting = new Greeting();
        greeting.setId(counter.getAndIncrement());
        greeting.setContent(String.format(GreetingController.TEMPLATE_STR, content));

        return greeting;
    }
}
