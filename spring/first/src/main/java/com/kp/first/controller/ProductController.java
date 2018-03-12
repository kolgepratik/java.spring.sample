package com.kp.first.controller;

import com.kp.first.model.Product;
import com.kp.first.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/product") public class ProductController {

    @Autowired private ProductRepository repository;


    @GetMapping("/") public String get() {
        StringBuilder sb = new StringBuilder();

        for (Product product : this.repository.findAll()) {
            sb.append(product.toString());
        }

        return sb.toString().length() == 0 ? "No Products in Database" : sb.toString();
    }

    @PostMapping("/") public String post() {
        this.repository.save(new Product("Mobile", "Android Phone", 800f));
        this.repository.save(new Product("Tablet", "Latest Tablet", 300f));

        return "Products Added";
    }

}
