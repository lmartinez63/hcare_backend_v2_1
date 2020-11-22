package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Event;
import com.landl.hcare.entity.EventGroup;
import com.landl.hcare.entity.SurgeryArea;
import com.landl.hcare.entity.SurgeryNurse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("retrieveSurgeryNurseInfo")
public class RetrieveSurgeryNurseInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_id = (String)requestMap.get("id");
        SurgeryNurse surgeryNurse = null;
        if(s_id != null){
            Long l_id = Long.parseLong(s_id);
            surgeryNurse = surgeryNurseService.findById(l_id);
        } else {
            String s_medicalSurgeryId = (String)requestMap.get("medicalSurgeryId");
            Long l_medicalSurgeryId = Long.parseLong(s_medicalSurgeryId);
            surgeryNurse = surgeryNurseService.createSurgeryNurse(l_medicalSurgeryId);
        }
        addDataToResultMap("surgeryNurse",surgeryNurse);
    }
}
