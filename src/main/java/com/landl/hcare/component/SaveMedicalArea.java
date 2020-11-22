package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.MedicalArea;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveMedicalArea")
public class SaveMedicalArea extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final MedicalArea medicalAreaRequest = mapper.convertValue(requestMap.get("medicalArea"), MedicalArea.class);
        MedicalArea medicalArea = medicalAreaService.save(medicalAreaRequest);
        addDataToResultMap("medicalArea",medicalArea);
    }
}
