package com.kp.first.controller;

import com.kp.first.bean.GlobalBeanRepository;
import com.kp.first.model.Customer;
import com.kp.first.repository.CustomerRepository;
import com.kp.first.util.IConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/app/customer*") public class CustomerRESTController
    extends SCrudRESTController<CustomerRepository, Customer> {

    @Autowired private GlobalBeanRepository globalBeanRepository;

    @Override @PostMapping("") public String post() {
        Customer customer = globalBeanRepository.beanMaker._newCustomer();
        customer.setDetails("prk", "prk", new String[] {"USER"});

        this.repository.save(customer);

        return IConstants.STATUS_SUCCESS;
    }
}
