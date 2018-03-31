package com.kp.first.bean;

import com.kp.first.repository.CustomerRepository;
import com.kp.first.repository.OrderRepository;
import com.kp.first.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component public class GlobalBeanRepository {
    @Autowired public ApplicationContext applicationContext;

    @Autowired public PasswordEncoder passwordEncoder;

    @Autowired public BeanMaker beanMaker;

    @Autowired public CustomerRepository customerRepository;
    @Autowired public ProductRepository productRepository;
    @Autowired public OrderRepository orderRepository;

    public void printBeans() {
        for (String bean : this.applicationContext.getBeanDefinitionNames())
            System.out.println(bean);
    }
}
