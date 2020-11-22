package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.SurgeryAnesthesia;
import com.landl.hcare.entity.SurgeryDoctor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveSurgeryAnesthesiaInfo")
public class RetrieveSurgeryAnesthesiaInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_surgeryAnesthesiaId = (String)requestMap.get("surgeryAnesthesiaId");
        SurgeryAnesthesia surgeryAnesthesia = null;
        if(s_surgeryAnesthesiaId != null){
            Long l_surgeryAnesthesiaId = Long.parseLong(s_surgeryAnesthesiaId);
            surgeryAnesthesia = surgeryAnesthesiaService.findById(l_surgeryAnesthesiaId);
        } else {
            String s_medicalSurgeryId = (String)requestMap.get("medicalSurgeryId");
            Long l_medicalSurgeryId = Long.parseLong(s_medicalSurgeryId);
            surgeryAnesthesia = surgeryAnesthesiaService.createSurgeryAnesthesia(l_medicalSurgeryId);
        }
        addDataToResultMap("surgeryAnesthesia",surgeryAnesthesia);
    }
}
