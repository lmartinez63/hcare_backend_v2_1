package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.SurgeryNurse;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveSurgeryNurse")
public class SaveSurgeryNurse extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final SurgeryNurse surgeryNurseRequest = mapper.convertValue(requestMap.get("surgeryNurse"), SurgeryNurse.class);
        SurgeryNurse surgeryNurse = null;
        if (surgeryNurseRequest.getId() != null){
            surgeryNurse = surgeryNurseService.findById(surgeryNurseRequest.getId());
            copyNonNullProperties(surgeryNurseRequest, surgeryNurse);
        } else {
            surgeryNurse = surgeryNurseRequest;
        }
        SurgeryNurse surgeryNurseSaved = surgeryNurseService.save(surgeryNurse);
        addDataToResultMap("surgeryNurse",surgeryNurseSaved);

    }



}
