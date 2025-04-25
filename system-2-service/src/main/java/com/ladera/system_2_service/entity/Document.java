package com.ladera.system_2_service.entity;

import com.ladera.system_2_service.enums.DocumentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Document extends AuditFile{
    @Column(unique = true)
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
