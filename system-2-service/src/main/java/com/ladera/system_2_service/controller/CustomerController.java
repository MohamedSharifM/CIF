package com.ladera.system_2_service.controller;

import com.ladera.system_2_service.dto.CustomerDto;
import com.ladera.system_2_service.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system-2")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.saveCustomer(customerDto), HttpStatus.CREATED);
    }

}
