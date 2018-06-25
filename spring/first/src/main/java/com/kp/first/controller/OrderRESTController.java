package com.kp.first.controller;

import com.kp.first.bean.GlobalBeanRepository;
import com.kp.first.model.Customer;
import com.kp.first.model.Order;
import com.kp.first.model.ProductPurchase;
import com.kp.first.repository.OrderRepository;
import com.kp.first.util.IConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController @RequestMapping("/app/order*") public class OrderRESTController
    extends SCrudRESTController<OrderRepository, Order> {

    @Autowired private GlobalBeanRepository globalBeanRepository;
    @Autowired private OrderRepository orderRepository;

    @Override @PostMapping("") public String post() {
        System.out.println("Saving new order");

        Order order = new Order();

        Customer customer = globalBeanRepository.customerRepository.findByUsername("kolgepratik");

        ProductPurchase pp = globalBeanRepository.beanMaker._newProductPurchase();
        pp.setDetails(globalBeanRepository.productRepository.findByName("Mobile"), 2);
        ProductPurchase pp2 = globalBeanRepository.beanMaker._newProductPurchase();
        pp2.setDetails(globalBeanRepository.productRepository.findByName("Tablet"), 5);
        order.setDetails(Arrays.asList(new ProductPurchase[] {pp, pp2}), customer);

        System.out.println("pp: " + pp);
        System.out.println("pp2: " + pp2);
        System.out.println("customer: " + customer);

        System.out.println("order: " + order);

        this.repository.save(order);

        return IConstants.STATUS_SUCCESS;
    }
}
