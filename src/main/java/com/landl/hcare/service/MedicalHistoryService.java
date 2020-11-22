package com.landl.hcare.service;


import com.landl.hcare.entity.MedicalHistory;
import com.landl.hcare.entity.Patient;

import java.util.List;
import java.util.Optional;

public interface MedicalHistoryService {

    public MedicalHistory save(MedicalHistory medicalHistory)  throws Exception;

    public List<MedicalHistory> findAll()  throws Exception;

    public MedicalHistory findById(Long historyCode) throws Exception;

    public MedicalHistory createMedicalHistory(Patient patient) throws Exception;

}
