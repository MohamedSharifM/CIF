package com.ladera.CDA_service.controller;

import com.ladera.CDA_service.integration.System_1_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ladera.CDA_service.dto.CustomerDto;
import com.ladera.CDA_service.service.CustomerService;

@RestController
@RequestMapping("/CDR")
public class CustomerRegisterController {
    @Autowired
	private CustomerService customerService;
	@PostMapping("/saveCustomer")
	public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto) {
		return customerService.saveCustomer(customerDto);
	}

	@PostMapping("/fetchAndSaveCustomer/{code}")
	public CustomerDto fetchAndSaveCustomer(@PathVariable String code){
		return customerService.fetchAndSaveTheCustomer(code);
	}
}
