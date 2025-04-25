package com.ladera.system_1_service.dto;

import com.ladera.system_1_service.enums.DocumentType;

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
