package com.landl.hcare.service;


import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.MedicalArea;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

public interface MedicalAreaService {

    public MedicalArea save(MedicalArea medicalArea);

    public List<MedicalArea> findAll();

    public List<AutoCompleteField> findIdAndAreaNameForAutoCompleteFields();

    public Optional<MedicalArea> findById(Long medicalAreaId);

}
