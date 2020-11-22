package com.landl.hcare.service;

import com.landl.hcare.entity.DocumentTemplate;

import java.util.List;


public interface DocumentTemplateService {

    public DocumentTemplate save(DocumentTemplate documentTemplate);

    public List<DocumentTemplate> findAll();

    public DocumentTemplate findById(Long documentTemplateId);

    public DocumentTemplate findByTemplateCode(String templateCode);
}
