package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Patient;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component("getPatientByDocumentNumber")
public class GetPatientByDocumentNumber extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final String documentNumber = mapper.convertValue(requestMap.get("documentNumber"), String.class);
        Patient patient = patientService.findByDocumentNumber(documentNumber);
        addDataToResultMap("patient",patient);
    }



}
