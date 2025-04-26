package com.ladera.CDA_service.dto;


import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
@Data
public class CustomerDto {

	private String customerId;
	private String customerName;
	private List<DocumentDto> documents;
	private LocalDateTime dob;
	private String phoneNo;
	private String emailId;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<DocumentDto> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentDto> documents) {
		this.documents = documents;
	}

	public LocalDateTime getDob() {
		return dob;
	}

	public void setDob(LocalDateTime dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}
