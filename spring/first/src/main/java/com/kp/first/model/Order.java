package com.kp.first.model;

import com.kp.first.impl.mongo.cascadesave.ACascadeSave;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE) public class Order
    implements IBaseModel {

    @Id private String id;

    @DBRef @ACascadeSave private Collection<ProductPurchase> productPurchases;
    @DBRef private Customer customer;

    private Float cost;

    public Order() {
        super();
    }

    public void setDetails(Collection<ProductPurchase> productPurchases, Customer customer) {
        this.productPurchases = productPurchases;
        this.customer = customer;
    }

    @Override public String toString() {
        return String
            .format("Order[id=%s, customer=%s, productPurchases=%s, cost=%s]", id, customer,
                productPurchases, cost);
    }

}
