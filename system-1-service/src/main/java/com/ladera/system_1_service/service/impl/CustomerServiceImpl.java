package com.ladera.system_1_service.service.impl;

import com.ladera.system_1_service.dao.CustomerRepository;
import com.ladera.system_1_service.dto.CustomerDto;
import com.ladera.system_1_service.entity.Customer;
import com.ladera.system_1_service.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDto.class);
    }

    @Override
    public CustomerDto getCustomerById(String code) {
        return null;
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        return null;
    }
}
