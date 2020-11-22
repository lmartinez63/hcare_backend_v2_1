package com.landl.hcare.service;

import com.landl.hcare.entity.Allergy;
import com.landl.hcare.entity.AutoCompleteField;

import java.util.List;

public interface AllergyService {

    public Allergy save(Allergy allergy);

    public List<Allergy> findAll();

    public Allergy findById(Long id);
    
    public List<AutoCompleteField> findCodeAndDescriptionForAutoCompleteFields();
    
    public Allergy createAllergy();

}
