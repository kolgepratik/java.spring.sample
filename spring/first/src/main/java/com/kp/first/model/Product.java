package com.kp.first.model;

import org.springframework.data.annotation.Id;

public class Product {

    @Id private String id;

    private String name;
    private String description;
    private Float cost;

    public Product() {
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
