package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.DocumentTemplate;
import com.landl.hcare.entity.MedicalArea;
import com.landl.hcare.service.DocumentGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("generateDocumentFromTemplate")
public class GenerateDocumentFromTemplate extends CustomProcess {

    @Autowired
    GetDSForDocumentAnesthesiaReport getDSForDocumentAnesthesiaReport;

    @Autowired
    GetDSForDocumentPostAnesthesiaReport getDSForDocumentPostAnesthesiaReport;

    @Autowired
    GetDSForDocumentInformedConsentReport getDSForDocumentInformedConsentReport;

    @Autowired
    GetDSForDocumentSurgeryReport getDSForDocumentSurgeryReport;

    @Autowired
    GetDSForDocumentVerificationListReport getDSForDocumentVerificationListReport;

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final DocumentTemplate documentTemplate = mapper.convertValue(requestMap.get("documentTemplate"), DocumentTemplate.class);
        String templateCode = documentTemplate.getTemplateCode();
        String outputFormat = documentTemplate.getOutputFormat();
        Map dataSource = null;
        switch (templateCode){
            case "anesthesiaReport":
                dataSource = getDSForDocumentAnesthesiaReport.getDS(requestMap);
                break;
            case "postAnesthesiaReport":
                dataSource = getDSForDocumentPostAnesthesiaReport.getDS(requestMap);
                break;
            case "informedConsentReport":
                dataSource = getDSForDocumentInformedConsentReport.getDS(requestMap);
                break;
            case "surgeryReport":
                dataSource = getDSForDocumentSurgeryReport.getDS(requestMap);
                break;
            case "verificationListReport":
                dataSource = getDSForDocumentVerificationListReport.getDS(requestMap);
                break;
            default:
                throw new Exception("No template registered");
        }
        String resultUrl = documentGenerationService.generateDocument(templateCode,outputFormat, dataSource);
        addDataToResultMap("resultUrl",resultUrl);
    }
}
