package com.kp.first.repository;

import com.kp.first.model.CustomerSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerSessionRepository extends CrudRepository<CustomerSession, String> {}
