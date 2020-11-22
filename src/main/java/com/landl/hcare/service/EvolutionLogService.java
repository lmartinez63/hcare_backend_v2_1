package com.landl.hcare.service;

import com.landl.hcare.entity.EvolutionLog;
import java.util.List;

public interface EvolutionLogService {

    public EvolutionLog save(EvolutionLog evolutionLog) throws Exception;

    public List<EvolutionLog> findAll() throws Exception;

    public EvolutionLog findById(Long evolutionLogId) throws Exception;

    public EvolutionLog createEventLog(Long medicalSurgeryId) throws Exception;

}
