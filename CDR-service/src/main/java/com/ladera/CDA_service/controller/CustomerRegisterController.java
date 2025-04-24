package com.ladera.CDA_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CDR")
public class CustomerRegisterController {
    @GetMapping("/demo")
    public String demo(){
        return "Service CDR";
    }
}
