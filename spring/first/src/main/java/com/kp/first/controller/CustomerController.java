package com.kp.first.controller;

import com.kp.first.config.BeanMaker;
import com.kp.first.model.Customer;
import com.kp.first.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/app/customer") public class CustomerController {

    @Autowired private BeanMaker beanMaker;

    @Autowired private CustomerRepository repository;

    @Autowired ApplicationContext applicationContext;

    @GetMapping("/") public String get() {
        StringBuilder sb = new StringBuilder();

        for (Customer customer : this.repository.findAll()) {
            sb.append(customer.toString());
        }

        return sb.toString().length() == 0 ? "No Customers in Database" : sb.toString();
    }

    @PostMapping("/") public String post() {
        Customer customer = beanMaker._newCustomer();
        customer.setDetails("kolgepratik", "kolgepratik", new String[] {"USER", "ADMIN"});

        this.repository.save(customer);

        return "Customer Added";
    }

}
