package com.landl.hcare.service;


import com.landl.hcare.entity.MedicalAnalysis;

import java.util.List;

public interface MedicalAnalysisService {

    public MedicalAnalysis save(MedicalAnalysis medicalAnalysis) throws Exception;

    public List<MedicalAnalysis> findAll() throws Exception;

    public MedicalAnalysis findById(Long medicalAnalysisId) throws Exception;

    public MedicalAnalysis createMedicalAnalysis(Long medicalSurgeryId) throws  Exception;

}
