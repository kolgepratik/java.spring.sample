package com.kp.first.controller;

import com.kp.first.model.Product;
import com.kp.first.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/app/product*") public class ProductController {

    @Autowired private ProductRepository repository;


    @GetMapping("") public String get() {
        StringBuilder sb = new StringBuilder();

        for (Product product : this.repository.findAll()) {
            sb.append(product.toString());
        }

        return sb.toString().length() == 0 ? "No Products in Database" : sb.toString();
    }

    @GetMapping("/{name}") public String item(@PathVariable("name") String name) {
        Product product = this.repository.findByName(name);

        return product == null ? "No Product found with the given name" : product.toString();
    }

    @PostMapping("") public String post() {
        this.repository.save(new Product("Mobile", "Android Phone", 800f));
        this.repository.save(new Product("Tablet", "Latest Tablet", 300f));

        return "Products Added";
    }

}
