package com.kp.first.bean;

import com.kp.first.repository.CustomerRepository;
import com.kp.first.repository.OrderRepository;
import com.kp.first.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component public class SingletonBeanFactory {
    @Autowired public ApplicationContext applicationContext;

    @Autowired public PasswordEncoder passwordEncoder;

<<<<<<< HEAD:spring/first/src/main/java/com/kp/first/bean/GlobalBeanRepository.java
    @Autowired public BeanMaker beanMaker;

    @Autowired public CustomerRepository customerRepository;
    @Autowired public ProductRepository productRepository;
    @Autowired public OrderRepository orderRepository;

    public void printBeans() {
        for (String bean : this.applicationContext.getBeanDefinitionNames())
            System.out.println(bean);
    }
=======
    @Autowired public BeanInstanceMaker beanInstanceMaker;
>>>>>>> 39444378c243112b82405eff02c254ab7240709a:spring/first/src/main/java/com/kp/first/bean/SingletonBeanFactory.java
}
