package com.landl.hcare.service;

import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.MedicalArea;
import com.landl.hcare.repository.MedicalAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalAreaServiceImpl implements MedicalAreaService{

    @Autowired
    MedicalAreaRepository medicalAreaRepository;

    public MedicalArea save(MedicalArea medicalArea){
        return medicalAreaRepository.save(medicalArea);
    }

    public List<MedicalArea> findAll(){
        return medicalAreaRepository.findAll();
    }

    public List<AutoCompleteField> findIdAndAreaNameForAutoCompleteFields() {
        return medicalAreaRepository.findIdAndAreaNameForAutoCompleteFields();
    }

    public Optional<MedicalArea> findById(Long medicalAreaId){
        return medicalAreaRepository.findById(medicalAreaId);
    }
    
}
