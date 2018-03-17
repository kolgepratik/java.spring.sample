package com.kp.first.bean;

import com.kp.first.model.Customer;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component public class BeanMaker {

    @Autowired private GlobalBeanRepository globalBeanRepository;

    @Autowired private ObjectFactory<Customer> customerBeanFactory;

    public Customer _newCustomer() {
        return customerBeanFactory.getObject();
    }

    public void printBeans() {

        for (String bean : globalBeanRepository.applicationContext.getBeanDefinitionNames())
            System.out.println(bean);
    }
}
