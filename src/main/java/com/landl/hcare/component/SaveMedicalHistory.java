package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.MedicalHistory;
import com.landl.hcare.entity.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveMedicalHistory")
public class SaveMedicalHistory extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final MedicalHistory medicalHistoryRequest = mapper.convertValue(requestMap.get("medicalHistory"), MedicalHistory.class);
        MedicalHistory medicalHistory = null;
        if (medicalHistoryRequest.getHistoryCode() != null){
            medicalHistory = medicalHistoryService.findById(medicalHistoryRequest.getHistoryCode());
            copyNonNullProperties(medicalHistoryRequest, medicalHistory);
        } else {
            medicalHistory = medicalHistoryRequest;
        }
        medicalHistoryService.save(medicalHistory);
        addDataToResultMap("medicalHistory",medicalHistory);
    }



}
