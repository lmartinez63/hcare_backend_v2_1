package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveEvolutionLogInfo")
public class RetrieveEvolutionLogInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_evolutionLogId = (String)requestMap.get("evolutionLogId");
        EvolutionLog evolutionLog = null;
        if(s_evolutionLogId != null){
            Long l_evolutionLogId = Long.parseLong(s_evolutionLogId);
            evolutionLog = evolutionLogService.findById(l_evolutionLogId);
        } else {
            String s_medicalSurgeryId = (String)requestMap.get("medicalSurgeryId");
            Long l_medicalSurgeryId = Long.parseLong(s_medicalSurgeryId);
            evolutionLog = evolutionLogService.createEventLog(l_medicalSurgeryId);
        }
        addDataToResultMap("evolutionLog",evolutionLog);
    }
}
