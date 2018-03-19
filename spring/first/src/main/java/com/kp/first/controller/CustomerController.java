package com.kp.first.controller;

import com.kp.first.bean.SingletonBeanFactory;
import com.kp.first.model.Customer;
import com.kp.first.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/app/customer*") public class CustomerController {

    @Autowired private SingletonBeanFactory singletonBeanFactory;

    @Autowired private CustomerRepository repository;

    @GetMapping("") public String get() {
        StringBuilder sb = new StringBuilder();

        for (Customer customer : this.repository.findAll()) {
            sb.append(customer.toString());
        }

        return sb.toString().length() == 0 ? "No Customers in Database" : sb.toString();
    }

    @PostMapping("") public String post() {
        Customer customer = singletonBeanFactory.beanInstanceMaker._newCustomer();
        customer.setDetails("kolgepratik", "kolgepratik", new String[] {"USER", "ADMIN"});

        this.repository.save(customer);

        return "Customer Added";
    }

}
