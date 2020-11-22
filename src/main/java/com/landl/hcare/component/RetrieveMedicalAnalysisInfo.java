package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Directory;
import com.landl.hcare.entity.MedicalAnalysis;
import com.landl.hcare.entity.MedicalSurgery;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveMedicalAnalysisInfo")
public class RetrieveMedicalAnalysisInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_medicalAnalysisId = (String)requestMap.get("medicalAnalysisId");
        MedicalAnalysis medicalAnalysis = null;
        if(s_medicalAnalysisId != null){
            Long l_medicalAnalysisId = Long.parseLong(s_medicalAnalysisId);
            medicalAnalysis = medicalAnalysisService.findById(l_medicalAnalysisId);
            medicalAnalysis.setLabelStatus(labelService.getByLabelCodeAndUserLanguage(medicalAnalysis.getStatus().toString(),"MEDICAL_ANALYSIS","STATUS").getLabelValueEsEs());
            if(medicalAnalysis.getAnalysisType() != null) {
                medicalAnalysis.setLabelAnalysisType(labelService.getByLabelCodeAndUserLanguage(medicalAnalysis.getAnalysisType().toString(), "MEDICAL_ANALYSIS", "ANALYSIS_TYPE").getLabelValueEsEs());
            }
            Directory directory = directoryService.findByEntityNameAndParentDirectoryIdIsNull("medical_analysis");
            directoryService.retrieveAttachmentInformation(directory,String.valueOf(medicalAnalysis.getId()));
            medicalAnalysis.setFiles(directoryService.convertDirectoryToFrontEndFormat(directory));

        } else {
            String s_medicalSurgeryId = (String)requestMap.get("medicalSurgeryId");
            Long l_medicalSurgeryId = Long.parseLong(s_medicalSurgeryId);
            medicalAnalysis = medicalAnalysisService.createMedicalAnalysis(l_medicalSurgeryId);
        }
        addDataToResultMap("medicalAnalysis",medicalAnalysis);
    }
}
