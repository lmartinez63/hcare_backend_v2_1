package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.EvolutionLog;
import com.landl.hcare.entity.UserProfile;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component("saveEvolutionLog")
public class SaveEvolutionLog extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final EvolutionLog evolutionLogRequest = mapper.convertValue(requestMap.get("evolutionLog"), EvolutionLog.class);
        EvolutionLog evolutionLog = null;
        if (evolutionLogRequest.getId() != null){
            evolutionLog = evolutionLogService.findById(evolutionLogRequest.getId());
            copyNonNullProperties(evolutionLogRequest, evolutionLog);

        } else {
            evolutionLog = evolutionLogRequest;
        }
        evolutionLog.setRegisteredBy((UserProfile)requestMap.get("userProfileAuthenticated"));
        evolutionLog.setEvolutionDatetime(new Date());
        EvolutionLog evolutionLogSaved = evolutionLogService.save(evolutionLog);
        addDataToResultMap("evolutionLog",evolutionLogSaved);
    }



}
