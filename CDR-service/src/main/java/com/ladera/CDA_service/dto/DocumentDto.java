package com.ladera.CDA_service.dto;

import com.ladera.CDA_service.enums.DocumentType;

import lombok.Data;

@Data
public class DocumentDto {
	private String documentNo;
	private DocumentType documentType;

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
}
