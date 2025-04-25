package com.ladera.CDA_service.dto;

import com.ladera.CDA_service.enums.DocumentType;

import lombok.Data;

@Data
public class DocumentsDto {

	private DocumentType documentType;
	private String documentNo;
}
