package com.kp.first.bean;

import com.kp.first.model.Customer;
import com.kp.first.model.ProductPurchase;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component public class BeanInstanceMaker {

    @Autowired private ObjectFactory<Customer> customerObjectFactory;
    @Autowired private ObjectFactory<ProductPurchase> productPurchaseObjectFactory;

    public Customer _newCustomer() {
        return customerObjectFactory.getObject();
    }

    public ProductPurchase _newProductPurchase() {
        return productPurchaseObjectFactory.getObject();
    }

}
