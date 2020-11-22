package com.landl.hcare.service;

import com.landl.hcare.entity.SurgeryAnesthesia;

import java.util.List;

public interface SurgeryAnesthesiaService {

    public SurgeryAnesthesia save(SurgeryAnesthesia surgeryAnesthesia) throws Exception;

    public List<SurgeryAnesthesia> findAll() throws Exception;

    public SurgeryAnesthesia findById(Long surgeryAnesthesiaId) throws Exception;

    public SurgeryAnesthesia createSurgeryAnesthesia(Long surgeryMedicalId) throws  Exception;

}
