package com.ladera.CDA_service.entity;

import com.ladera.CDA_service.enums.DocumentType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Documents extends AuditFile {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long pk;
	private DocumentType documentType;
	private String documentNo;
}
