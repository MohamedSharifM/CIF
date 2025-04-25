package com.ladera.system_1_service.service;

import com.ladera.system_1_service.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    public CustomerDto saveCustomer(CustomerDto customerDto);
    public CustomerDto getCustomerById(String code);
    public List<CustomerDto> getAllCustomer();
}
