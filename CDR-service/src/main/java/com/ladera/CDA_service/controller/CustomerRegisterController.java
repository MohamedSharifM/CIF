package com.ladera.CDA_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
