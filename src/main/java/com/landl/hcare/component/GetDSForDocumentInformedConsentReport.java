package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.MedicalSurgery;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.service.MedicalSurgeryService;
import com.landl.hcare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("getDSForDocumentInformedConsentReport")
public class GetDSForDocumentInformedConsentReport {

    @Autowired
    MedicalSurgeryService medicalSurgeryService;

    @Autowired
    PatientService patientService;

    public Map getDS(Map<String, Object> incomingRequestMap) throws Exception {
        Map resultDSMap = new HashMap();
        Map dataSourceParameters = new HashMap();
        Map reportParameters = new HashMap();
        ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        MedicalSurgery medicalSurgeryRequested = mapper.convertValue(incomingRequestMap.get("medicalSurgery"), MedicalSurgery.class);
        MedicalSurgery medicalSurgery = medicalSurgeryService.findById(medicalSurgeryRequested.getId());
        medicalSurgeryService.getObjectLabeled(medicalSurgery);
        Patient patient = medicalSurgery.getMedicalAppointment().getPatient();
        dataSourceParameters.put("patient",patient);
        dataSourceParameters.put("medicalSurgery",medicalSurgery);
        reportParameters.put("reportTitle","Consentimiento Informado");
        resultDSMap.put("dataSourceParameters",dataSourceParameters);
        resultDSMap.put("reportParameters",reportParameters);
        return resultDSMap;
    }


}
