package com.landl.hcare.repository;

import com.landl.hcare.entity.DocumentTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentTemplateRepository extends JpaRepository<DocumentTemplate, Long>{
    List<DocumentTemplate> findByTemplateCode(String templateCode);
}
