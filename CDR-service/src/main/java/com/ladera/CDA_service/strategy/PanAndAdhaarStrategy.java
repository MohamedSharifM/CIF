package com.ladera.CDA_service.strategy;

import org.springframework.stereotype.Component;

@Component
public class PanAndAdhaarStrategy implements CustomerIdGenerationStrategy {

	@Override
	public boolean supports(boolean hasAadhaar, boolean hasPan) {
		// TODO Auto-generated method stub
		 return hasAadhaar && hasPan;
	}

	@Override
	public String generateId(String adhaar, String pan) {
		// TODO Auto-generated method stub
		return "ADPAN"+(adhaar+pan).hashCode();
	}

}
