package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.FamiliarBackground;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveFamiliarBackgroundInfo")
public class RetrieveFamiliarBackgroundInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_familiarBackgroundId = (String)requestMap.get("familiarBackgroundId");
        FamiliarBackground familiarBackground = null;
        if(s_familiarBackgroundId != null){
            Long l_familiarBackgroundId = Long.parseLong(s_familiarBackgroundId);
            familiarBackground = familiarBackgroundService.findById(l_familiarBackgroundId);
        } else {
        	String s_medicalAppointmentId = (String)requestMap.get("medicalAppointmentId");
            Long l_medicalAppointmentId = Long.parseLong(s_medicalAppointmentId);
        	familiarBackground = familiarBackgroundService.createFamiliarBackground(l_medicalAppointmentId);
        }
        addDataToResultMap("familiarBackground",familiarBackground);
    }



}
