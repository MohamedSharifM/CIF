package com.ladera.CDA_service.service.impl;

import java.util.List;

import com.ladera.CDA_service.integration.System_1_service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ladera.CDA_service.dto.CustomerDto;
import com.ladera.CDA_service.entity.Customer;
import com.ladera.CDA_service.entity.Document;
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
	@Autowired
	private CustomerIdGeneratorService customerIdGeneratorService;

	private System_1_service system_1_service;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);


	@Override
	public CustomerDto saveCustomer(CustomerDto customer) {
		

	  List<Document> DocumentModel=	customer.getDocuments().stream().map(doc->{
			Document model=new Document();
			modelMapper.map(doc, model);
			return model;
		}).toList();
	  List<Document> savedDocument= documentsRepo.saveAll(DocumentModel);
        
		Customer customerModel = modelMapper.map(customer, Customer.class);
	
		String adhaar = "";
		String pan = "";
		for (Document doc : savedDocument) {
			logger.info(doc.getDocumentType()+"----------------DocType");
			if (doc.getDocumentType().equals(DocumentType.AADHAAR_CARD)) {
				adhaar = doc.getDocumentNo();
				
			} else if (doc.getDocumentType().equals(DocumentType.PAN_CARD)) {
				pan = doc.getDocumentNo();
			}
		}
		String generatedId = customerIdGeneratorService.generateCustomerId(adhaar, pan); 
		customerModel.setCustomerId(generatedId);
		customerModel.setCustomerId(generatedId);
		customerModel.setDocuments(DocumentModel);

		Customer savedCustomer = customerRepo.save(customerModel);

		return modelMapper.map(savedCustomer, CustomerDto.class);
	}


//	public String generateCustomerId(String aadhaar, String pan) {
//		boolean hasAadhaar = aadhaar != null && !aadhaar.isBlank();
//		boolean hasPan = pan != null && !pan.isBlank();
//
//		if (hasAadhaar && hasPan) {
//			return "AADPAN-" + (aadhaar + pan).hashCode();
//		} else if (hasAadhaar) {
//			return "AAD-" + aadhaar.hashCode();
//		} else if (hasPan) {
//			return "PAN-" + pan.hashCode();
//		} else {
//			throw new IllegalArgumentException("At least Aadhaar or PAN must be provided");
//		}
//	}

	@Override
	public CustomerDto fetchAndSaveTheCustomer(String code) {
		CustomerDto customerdto = system_1_service.getCustomerById(code).getBody();
		Customer customer = modelMapper.map(customerdto,Customer.class);
		Customer savedCustomer = customerRepo.save(customer);
		return modelMapper.map(savedCustomer,CustomerDto.class);
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

