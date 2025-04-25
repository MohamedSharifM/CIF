package com.ladera.CDA_service.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Customer extends AuditFile {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long PK;
	private String customerUId;
	private String name;
	@OneToMany
	private List<Documents> documents;
	private LocalDate dob;
	private String email;
	private long contact;
}
