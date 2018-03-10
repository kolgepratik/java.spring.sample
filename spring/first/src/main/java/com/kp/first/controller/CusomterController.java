package com.kp.first.controller;

import com.kp.first.model.Customer;
import com.kp.first.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/customer") public class CusomterController {

    @Autowired private CustomerRepository repository;


    @GetMapping("/") public String get() {
        StringBuilder sb = new StringBuilder();

        for (Customer customer : this.repository.findAll()) {
            sb.append(customer.toString());
        }

        return sb.toString();
    }

    @PostMapping("/") public String post() {
        this.repository.save(new Customer("Alice", "Smith"));
        this.repository.save(new Customer("Bob", "Smith"));

        return "Added";
    }

}
