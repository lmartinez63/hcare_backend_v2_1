package com.landl.hcare.service;

import com.landl.hcare.entity.MedicalAnalysis;
import com.landl.hcare.entity.MedicalSurgery;
import com.landl.hcare.entity.type.MedicalAnalysisStatus;
import com.landl.hcare.entity.type.MedicalSurgeryStatus;
import com.landl.hcare.repository.MedicalAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalAnalysisServiceImpl implements MedicalAnalysisService {

    @Autowired
    MedicalAnalysisRepository medicalAnalysisRepository;

    public MedicalAnalysis save(MedicalAnalysis medicalAnalysis) throws Exception{
        return medicalAnalysisRepository.save(medicalAnalysis);
    }

    public List<MedicalAnalysis> findAll() throws Exception{
        return medicalAnalysisRepository.findAll();
    }

    public MedicalAnalysis findById(Long medicalAnalysisId) throws Exception{
        return medicalAnalysisRepository.findById(medicalAnalysisId).get();
    }

    public MedicalAnalysis createMedicalAnalysis(Long medicalSurgeryId) throws  Exception{
        MedicalAnalysis medicalAnalysis = new MedicalAnalysis();
        medicalAnalysis.setStatus(MedicalAnalysisStatus.PENDING);
        //InternalType
        medicalAnalysis.setType(1);
        medicalAnalysis.setMedicalSurgeryId(medicalSurgeryId);
        return medicalAnalysis;
    }
}
