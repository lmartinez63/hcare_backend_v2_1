package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("savePatient")
public class SavePatient extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final Patient patientRequest = mapper.convertValue(requestMap.get("patient"), Patient.class);
        Patient patient;
        if(patientRequest.getId() != null) {
            patient = patientService.findById(patientRequest.getId());
            copyNonNullProperties(patientRequest, patient);
        } else {
            patient = patientRequest;
        }
        patientService.save(patient);
        addDataToResultMap("patient",patient);
    }



}
