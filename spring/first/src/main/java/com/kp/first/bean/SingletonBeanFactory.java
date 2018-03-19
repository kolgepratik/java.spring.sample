package com.kp.first.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component public class SingletonBeanFactory {
    @Autowired public ApplicationContext applicationContext;

    @Autowired public PasswordEncoder passwordEncoder;

    @Autowired public BeanInstanceMaker beanInstanceMaker;
}
