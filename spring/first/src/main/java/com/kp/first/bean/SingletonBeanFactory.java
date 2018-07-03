package com.kp.first.bean;

import com.kp.first.repository.CustomerRepository;
import com.kp.first.repository.CustomerSessionRepository;
import com.kp.first.repository.OrderRepository;
import com.kp.first.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component public class SingletonBeanFactory {
    @Autowired public ApplicationContext applicationContext;

    @Autowired public PasswordEncoder passwordEncoder;

    @Autowired public CustomerRepository customerRepository;
    @Autowired public CustomerSessionRepository customerSessionRepository;
    @Autowired public ProductRepository productRepository;
    @Autowired public OrderRepository orderRepository;

    @Autowired public BeanInstanceMaker beanInstanceMaker;

    public void printBeans() {
        System.out.println("-------------------------------");
        System.out.println("----- Printing all beans ------");
        for (String bean : this.applicationContext.getBeanDefinitionNames()) {
            System.out.println(bean);
        }
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
    }
}


@Component
class SingletonBeanFactoryBean {
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }
}
