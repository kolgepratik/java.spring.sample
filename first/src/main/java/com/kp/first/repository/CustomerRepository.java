package com.kp.first.repository;

import com.kp.first.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Customer findByUsername(String username);

    List<Customer> findByLastName(String lastName);

}
