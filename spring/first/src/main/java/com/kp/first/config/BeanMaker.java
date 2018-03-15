package com.kp.first.config;

import com.kp.first.model.Customer;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component public class BeanMaker {

    @Autowired ApplicationContext applicationContext;

    @Autowired private ObjectFactory<Customer> customerBeanFactory;

    public Customer _newCustomer() {
        return customerBeanFactory.getObject();
    }

    public void printBeans() {
        for (String bean : applicationContext.getBeanDefinitionNames())
            System.out.println(bean);
    }
}
