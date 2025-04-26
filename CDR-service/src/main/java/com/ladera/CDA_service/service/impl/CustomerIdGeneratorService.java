package com.ladera.CDA_service.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ladera.CDA_service.strategy.CustomerIdGenerationStrategy;



@Service
public class CustomerIdGeneratorService {

    private final List<CustomerIdGenerationStrategy> strategies;

    public CustomerIdGeneratorService(List<CustomerIdGenerationStrategy> strategies) {
        this.strategies = strategies;
    }

    public String generateCustomerId(String aadhaar, String pan) {
        boolean hasAadhaar = aadhaar != null && !aadhaar.isEmpty();
        boolean hasPan = pan != null && !pan.isEmpty();

        return strategies.stream()
                .filter(strategy -> strategy.supports(hasAadhaar, hasPan))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No suitable strategy found"))
                .generateId(aadhaar, pan);
    }
}
