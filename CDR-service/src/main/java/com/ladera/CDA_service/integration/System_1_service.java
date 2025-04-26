package com.ladera.CDA_service.integration;

import com.ladera.CDA_service.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("SYSTEM-1-SERVICE")
public interface System_1_service {
    @PostMapping("/system-1/saveCustomer")
    public ResponseEntity<CustomerDto> saveCustomer(@RequestBody CustomerDto customerDto);
    @GetMapping("/system-1/getCustomerById/{code}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable String code);
    @GetMapping("/system-1/getAllCustomers")
    public ResponseEntity<List<CustomerDto>> getAllCustomers();
}
