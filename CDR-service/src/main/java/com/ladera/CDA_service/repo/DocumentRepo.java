package com.ladera.CDA_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ladera.CDA_service.entity.Document;
@Repository
public interface DocumentRepo extends JpaRepository<Document, Long> {

}
