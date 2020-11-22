package com.landl.hcare.service;

import com.landl.hcare.entity.FieldDefinition;
import com.landl.hcare.entity.Validation;

import java.util.List;
import java.util.Optional;

public interface ValidationService {

    public Validation save(Validation validation);

    public List<Validation> findAll();

    public Optional<Validation> findById(Long validationId);

    public List<Validation> getValidationsByFieldDefinition(FieldDefinition fieldDefinition);

    public List<Validation> getValidationsByFieldDefinition(Long pageId, Long sectionId, Long fieldDefinitionId);

}
