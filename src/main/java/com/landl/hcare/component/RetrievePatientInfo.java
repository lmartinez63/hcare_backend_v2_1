package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Directory;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrievePatientInfo")
public class RetrievePatientInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_patientId = (String)requestMap.get("patientId");
        Patient patient = null;
        if(s_patientId != null){
            Long l_patientId = Long.parseLong(s_patientId);
            //final Patient patientRequest = mapper.convertValue(requestMap.get("patient"), Patient.class);

            patient = patientService.findById(l_patientId);
            Directory directory = directoryService.findByEntityNameAndParentDirectoryIdIsNull("patient");
            directoryService.retrieveAttachmentInformation(directory,String.valueOf(l_patientId));
            patient.setFiles(directoryService.convertDirectoryToFrontEndFormat(directory));
        } else {
            patient = patientService.createPatient();
        }
        addDataToResultMap("patient",patient);
    }



}
