package com.ladera.CDA_service.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ladera.CDA_service.dto.CustomerDto;
import com.ladera.CDA_service.entity.Customer;
import com.ladera.CDA_service.entity.Documents;
import com.ladera.CDA_service.enums.DocumentType;
import com.ladera.CDA_service.repo.CustomerRepo;
import com.ladera.CDA_service.repo.DocumentRepo;
import com.ladera.CDA_service.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private DocumentRepo documentsRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


	@Override
	public CustomerDto saveCustomer(CustomerDto customer) {
		

	  List<Documents> DocumentModel=	customer.getDocuments().stream().map(doc->{
			Documents model=new Documents();
			modelMapper.map(doc, model);
			return model;
		}).toList();
	  List<Documents> savedDocument= documentsRepo.saveAll(DocumentModel);
        
		Customer customerModel = modelMapper.map(customer, Customer.class);
	
		String adhaar = "";
		String pan = "";
		for (Documents doc : savedDocument) {
			logger.info(doc.getDocumentType()+"----------------DocType");
			if (doc.getDocumentType().equals(DocumentType.ADHAAR_CARD)) {
				adhaar = doc.getDocumentNo();
				
			} else if (doc.getDocumentType().equals(DocumentType.PAN_CARD)) {
				pan = doc.getDocumentNo();
			}
		}
		String generatedId = generateCustomerId(adhaar, pan);
		customerModel.setCustomerUId(generatedId);
		customerModel.setDocuments(DocumentModel);

		Customer savedCustomer = customerRepo.save(customerModel);

		return modelMapper.map(savedCustomer, CustomerDto.class);
	}

	public String generateCustomerId(String aadhaar, String pan) {
		boolean hasAadhaar = aadhaar != null && !aadhaar.isBlank();
		boolean hasPan = pan != null && !pan.isBlank();

		if (hasAadhaar && hasPan) {
			return "AADPAN-" + (aadhaar + pan).hashCode();
		} else if (hasAadhaar) {
			return "AAD-" + aadhaar.hashCode();
		} else if (hasPan) {
			return "PAN-" + pan.hashCode();
		} else {
			throw new IllegalArgumentException("At least Aadhaar or PAN must be provided");
		}
	}
}

