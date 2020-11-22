package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Directory;
import com.landl.hcare.entity.MedicalHistory;
import com.landl.hcare.entity.Patient;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

@Component("retrieveMedicalHistoryInfo")
public class RetrieveMedicalHistoryInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{
    	
        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        //final MedicalHistory medicalHistoryRequest = mapper.convertValue(requestMap.get("medicalHistory"), MedicalHistory.class);
        String s_historyCode = (String)requestMap.get("historyCode");
        Long l_historyCode = Long.parseLong(s_historyCode);
        if(l_historyCode != null){
            MedicalHistory medicalHistory = medicalHistoryService.findById(l_historyCode);
            if (medicalHistory != null) {
                if(medicalHistory.getHistoryCode() != null){
                    medicalHistory.setPatient(patientService.findByHistoryCode(medicalHistory.getHistoryCode()));
                    //medicalHistory.setAttachmentList(attachmentService.findByEntityAndEntityId("medicalHistory", medicalHistory.getHistoryCode()));
                    Directory directory = directoryService.findByEntityName("medical_history");
                    directoryService.retrieveAttachmentInformation(directory,String.valueOf(l_historyCode));
                    medicalHistory.setFiles(directoryService.convertDirectoryToFrontEndFormat(directory));
                }
            }
            addDataToResultMap("medicalHistory",medicalHistory);
        } else {
            //TODO
            throw new Exception("History Code must not me empty");
        }

    }
}