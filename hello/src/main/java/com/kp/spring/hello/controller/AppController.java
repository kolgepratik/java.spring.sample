package com.kp.spring.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    @RequestMapping("/") public String index() {
        return "index";
    }

    @GetMapping("/login") public String login() {
        System.out.println("MainController: login(): GET");
        return "login";
    }

    @PostMapping("/login") public String doLogin() {
        System.out.println("MainController: login(): POST");
        return "login";
    }

    @GetMapping("/error") public String error() {
        System.out.println("MainController: error(): GET");
        return "error";
    }

    @GetMapping("/app/home") public String home() {
        System.out.println("MainController: home(): GET");
        return "home";
    }
}
