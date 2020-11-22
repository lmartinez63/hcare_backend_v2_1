package com.landl.hcare.service;

import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.CIE10;
import com.landl.hcare.entity.Label;
import com.landl.hcare.entity.Property;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CIE10Service {

    public CIE10 save(CIE10 cie10);

    public List<CIE10> findAll();

    public CIE10 findById(Long id);
    
    public List<AutoCompleteField> findCodeAndDescriptionForAutoCompleteFields();

}
