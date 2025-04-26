package com.ladera.CDA_service.strategy;

import org.springframework.stereotype.Component;

@Component
public class PanOnlyStrategy implements CustomerIdGenerationStrategy {

	@Override
	public boolean supports(boolean hasAadhaar, boolean hasPan) {
		// TODO Auto-generated method stub
		  return !hasAadhaar && hasPan;
	}

	@Override
	public String generateId(String aadhaar, String pan) {
		// TODO Auto-generated method stub
		return "AD"+pan.hashCode();
		
	}
}
