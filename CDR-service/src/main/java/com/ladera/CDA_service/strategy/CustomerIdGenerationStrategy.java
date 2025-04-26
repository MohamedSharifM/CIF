package com.ladera.CDA_service.strategy;

public interface CustomerIdGenerationStrategy {

	boolean supports(boolean hasAadhaar, boolean hasPan);
    String generateId(String aadhaar, String pan);
}
