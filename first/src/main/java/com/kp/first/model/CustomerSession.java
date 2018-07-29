package com.kp.first.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RedisHash("CustomerSession")
public class CustomerSession {

    // Customer.id
    String id;

    // Customer
    Customer customer;

    Date sessionStartDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getSessionStartDate() {
        return sessionStartDate;
    }

    public void setSessionStartDate(Date sessionStartDate) {
        this.sessionStartDate = sessionStartDate;
    }
}
