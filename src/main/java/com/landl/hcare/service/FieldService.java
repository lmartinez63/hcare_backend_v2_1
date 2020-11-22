package com.landl.hcare.service;


import com.landl.hcare.entity.FieldDefinition;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FieldService {

    public FieldDefinition save(FieldDefinition fieldDefinition);

    public List<FieldDefinition> findAll();

    public List<FieldDefinition> getFieldsByPageSectionCodeAndUsername(String pageCode, String serviceCode,String username);

    public List<FieldDefinition> getFieldsBySectionCode(String serviceCode);

    public FieldDefinition findById(Long fieldId);

    public FieldDefinition createFieldDefinition();

    public void evaluateRules(FieldDefinition fieldDefinition, Map dataSource);

    public void evaluateFields(FieldDefinition fieldDefinition, Map dataSource) throws  Exception;

}
