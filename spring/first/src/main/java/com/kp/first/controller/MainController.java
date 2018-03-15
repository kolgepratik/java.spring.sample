package com.kp.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller public class MainController {

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

}
