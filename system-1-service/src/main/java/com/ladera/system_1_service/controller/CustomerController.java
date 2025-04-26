package com.ladera.system_1_service.controller;

import com.ladera.system_1_service.dto.CustomerDto;
import com.ladera.system_1_service.service.CustomerService;
import com.ladera.system_1_service.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system-1")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @PostMapping("/saveCustomer")
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.saveCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping("/getCustomerById/{code}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String code){
        return new ResponseEntity<>(customerService.getCustomerById(code),HttpStatus.OK);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
    }
}
