package com.landl.hcare.repository;

import com.landl.hcare.entity.EmailTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, Long>{
    List<EmailTemplate> findByTemplateType(String templateType);
}
