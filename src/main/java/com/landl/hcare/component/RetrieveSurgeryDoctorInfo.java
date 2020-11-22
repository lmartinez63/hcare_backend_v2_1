package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.SurgeryDoctor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveSurgeryDoctorInfo")
public class RetrieveSurgeryDoctorInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_id = (String)requestMap.get("id");
        SurgeryDoctor surgeryDoctor = null;
        if(s_id != null){
            Long l_id = Long.parseLong(s_id);
            surgeryDoctor = surgeryDoctorService.findById(l_id);
        } else {
            String s_medicalSurgeryId = (String)requestMap.get("medicalSurgeryId");
            Long l_medicalSurgeryId = Long.parseLong(s_medicalSurgeryId);
            surgeryDoctor = surgeryDoctorService.createSurgeryDoctor(l_medicalSurgeryId);
        }
        addDataToResultMap("surgeryDoctor",surgeryDoctor);
    }
}
