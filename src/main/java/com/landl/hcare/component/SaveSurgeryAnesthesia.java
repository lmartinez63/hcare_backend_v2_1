package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.SurgeryAnesthesia;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveSurgeryAnesthesia")
public class SaveSurgeryAnesthesia extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final SurgeryAnesthesia surgeryAnesthesiaRequest = mapper.convertValue(requestMap.get("surgeryAnesthesia"), SurgeryAnesthesia.class);
        SurgeryAnesthesia surgeryAnesthesia = null;
        if (surgeryAnesthesiaRequest.getId() != null){
            surgeryAnesthesia = surgeryAnesthesiaService.findById(surgeryAnesthesiaRequest.getId());
            copyNonNullProperties(surgeryAnesthesiaRequest, surgeryAnesthesia);
        } else {
            surgeryAnesthesia = surgeryAnesthesiaRequest;
        }
        SurgeryAnesthesia surgeryAnesthesiaSaved = surgeryAnesthesiaService.save(surgeryAnesthesia);
        addDataToResultMap("surgeryAnesthesia",surgeryAnesthesiaSaved);

    }



}
