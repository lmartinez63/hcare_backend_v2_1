package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.SurgeryArea;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveSurgeryArea")
public class SaveSurgeryArea extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final SurgeryArea surgeryAreaRequest = mapper.convertValue(requestMap.get("surgeryArea"), SurgeryArea.class);
        SurgeryArea surgeryArea = null;
        if (surgeryAreaRequest.getId() != null){
            surgeryArea = surgeryAreaService.findById(surgeryAreaRequest.getId());
            copyNonNullProperties(surgeryAreaRequest, surgeryArea);
        } else {
            surgeryArea = surgeryAreaRequest;
        }
        SurgeryArea surgeryAreaSaved = surgeryAreaService.save(surgeryArea);
        addDataToResultMap("surgeryArea",surgeryAreaSaved);

    }



}
