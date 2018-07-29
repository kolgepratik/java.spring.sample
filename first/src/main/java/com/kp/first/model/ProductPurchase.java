package com.kp.first.model;

import com.kp.first.bean.SingletonBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;

@Component @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) public class ProductPurchase
    implements IBaseModel {

    @Autowired private SingletonBeanFactory singletonBeanFactory;

    @Id private String id;

    @DBRef private Product product;

    private Integer quantity;

    public ProductPurchase() {
        super();
    }

    public void setDetails(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override public String toString() {
        return "ProductPurchase{" + "id='" + id + '\'' + ", product=" + product + ", quantity="
            + quantity + '}';
    }
}
