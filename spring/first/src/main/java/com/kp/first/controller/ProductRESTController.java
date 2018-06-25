package com.kp.first.controller;

import com.kp.first.bean.SingletonBeanFactory;
import com.kp.first.model.Product;
import com.kp.first.repository.ProductRepository;
import com.kp.first.util.IConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/app/pr*") public class ProductRESTController
    extends SCrudRESTController<ProductRepository, Product> {

    @Autowired private SingletonBeanFactory singletonBeanFactory;

    @Override @PostMapping("") public String post() {
        this.repository.save(new Product("Mobile", "Android Phone", 800f));
        this.repository.save(new Product("Tablet", "Latest Tablet", 300f));

        return IConstants.STATUS_SUCCESS;
    }
}
