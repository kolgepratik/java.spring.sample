package com.kp.first.controller;

import com.kp.first.bean.SingletonBeanFactory;
import com.kp.first.model.Customer;
import com.kp.first.repository.CustomerRepository;
import com.kp.first.util.IConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/app/customer*") public class CustomerRESTController
    extends SCrudRESTController<CustomerRepository, Customer> {

    @Autowired private SingletonBeanFactory singletonBeanFactory;

<<<<<<< HEAD:spring/first/src/main/java/com/kp/first/controller/CustomerRESTController.java
    @Override @PostMapping("") public String post() {
        Customer customer = globalBeanRepository.beanMaker._newCustomer();
        customer.setDetails("prk", "prk", new String[] {"USER"});
=======
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
>>>>>>> 39444378c243112b82405eff02c254ab7240709a:spring/first/src/main/java/com/kp/first/controller/CustomerController.java

        this.repository.save(customer);

        return IConstants.STATUS_SUCCESS;
    }
}
