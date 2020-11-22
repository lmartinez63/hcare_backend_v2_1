package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.SurgeryDoctor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveSurgeryDoctor")
public class SaveSurgeryDoctor extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final SurgeryDoctor surgeryDoctorRequest = mapper.convertValue(requestMap.get("surgeryDoctor"), SurgeryDoctor.class);
        SurgeryDoctor surgeryDoctor = null;
        if (surgeryDoctorRequest.getId() != null){
            surgeryDoctor = surgeryDoctorService.findById(surgeryDoctorRequest.getId());
            copyNonNullProperties(surgeryDoctorRequest, surgeryDoctor);
        } else {
            surgeryDoctor = surgeryDoctorRequest;
        }
        SurgeryDoctor surgeryDoctorSaved = surgeryDoctorService.save(surgeryDoctor);
        addDataToResultMap("surgeryDoctor",surgeryDoctorSaved);

    }



}
