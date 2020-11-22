package com.landl.hcare.service;

import com.landl.hcare.entity.*;
import com.landl.hcare.entity.type.MedicalSurgeryStatus;
import com.landl.hcare.repository.EvolutionLogRepository;
import com.landl.hcare.repository.MedicalSurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EvolutionLogServiceImpl extends ObjectServiceImpl implements EvolutionLogService {

    @Autowired
    EvolutionLogRepository evolutionLogRepository;


    public EvolutionLog save(EvolutionLog evolutionLog) throws Exception{
        return evolutionLogRepository.save(evolutionLog);
    }

    public List<EvolutionLog> findAll() throws Exception{
        return evolutionLogRepository.findAll();
    }

    public EvolutionLog findById(Long evolutionLogId) throws Exception{
        return evolutionLogRepository.findById(evolutionLogId).get();
    }

    public EvolutionLog createEventLog(Long medicalSurgeryId) throws Exception{
        EvolutionLog evolutionLog = new EvolutionLog();
        evolutionLog.setMedicalSurgeryId(medicalSurgeryId);
        return evolutionLog;
    }

}
