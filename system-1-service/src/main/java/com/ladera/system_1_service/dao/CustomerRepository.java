package com.ladera.system_1_service.dao;

import com.ladera.system_1_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    public Customer getCustomerBycustomerId(String customerId);
}
