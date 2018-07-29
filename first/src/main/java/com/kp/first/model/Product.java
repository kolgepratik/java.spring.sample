package com.kp.first.model;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) public class Product {

    @Id private String id;

    private String name;
    private String description;
    private Float cost;

    public Product() {
        super();
    }

    public Product(String name, String description, Float cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    @Override public String toString() {
        return String
            .format("Product[id=%s, name='%s', description='%s', cost='%s']", id, name, description,
                cost);
    }

}
