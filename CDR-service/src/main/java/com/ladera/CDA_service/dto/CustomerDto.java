package com.ladera.CDA_service.dto;


import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
@Data
public class CustomerDto {

	private String customerId;
	private String name;
	private List<DocumentsDto> documents;
	private LocalDateTime dob;
	private String email;
	private long contact;
}
