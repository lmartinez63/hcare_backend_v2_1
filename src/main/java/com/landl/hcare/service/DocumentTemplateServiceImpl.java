package com.landl.hcare.service;

import com.landl.hcare.entity.DataTable;
import com.landl.hcare.entity.DocumentTemplate;
import com.landl.hcare.repository.DocumentTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTemplateServiceImpl implements DocumentTemplateService{


    @Autowired
    DocumentTemplateRepository documentTemplateRepository;

    public DocumentTemplate save(DocumentTemplate documentTemplate){
        return documentTemplateRepository.save(documentTemplate);
    }

    public List<DocumentTemplate> findAll(){
        return documentTemplateRepository.findAll();
    }

    public DocumentTemplate findById(Long documentTemplateId){
        return documentTemplateRepository.findById(documentTemplateId).get();
    }

    public DocumentTemplate findByTemplateCode(String templateCode){
        return documentTemplateRepository.findByTemplateCode(templateCode).get(0);
    }

}
