package com.landl.hcare.service;

import com.landl.hcare.entity.MedicalHistory;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.repository.MedicalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalHistoryServiceImpl implements MedicalHistoryService {

    @Autowired
    MedicalHistoryRepository medicalHistoryRepository;

    public MedicalHistory save(MedicalHistory medicalHistory)  throws Exception{
        return medicalHistoryRepository.save(medicalHistory);
    }

    public List<MedicalHistory> findAll() throws Exception{
        return medicalHistoryRepository.findAll();
    }

    public MedicalHistory findById(Long historyCode) throws Exception{
        return medicalHistoryRepository.findById(historyCode).orElse(null);
    }

    public MedicalHistory createMedicalHistory(Patient patient) throws Exception{
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setHistoryActivity(true);
        medicalHistory.setStatus("0");
        MedicalHistory medicalHistorySaved = save(medicalHistory);
        Long historyCode = medicalHistorySaved.getHistoryCode();
        if(patient.getHistoryCode() == null){
            patient.setHistoryCode(historyCode);

        }
        return medicalHistorySaved;
    }
}
