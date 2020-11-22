package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.MedicalAppointmentMedicament;
import com.landl.hcare.entity.SurgeryDoctor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveMedicalAppointmentMedicamentInfo")
public class RetrieveMedicalAppointmentMedicamentInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_id = (String)requestMap.get("id");
        MedicalAppointmentMedicament medicalAppointmentMedicament = null;
        if(s_id != null){
            Long l_id = Long.parseLong(s_id);
            medicalAppointmentMedicament = medicalAppointmentMedicamentService.findById(l_id);
            medicalAppointmentMedicamentService.getObjectLabeled(medicalAppointmentMedicament);
        } else {
            String s_medicalAppointmentId = (String)requestMap.get("medicalAppointmentId");
            Long l_medicalAppointmentId = Long.parseLong(s_medicalAppointmentId);
            medicalAppointmentMedicament = medicalAppointmentMedicamentService.createMedicalAppointmentMedicament(l_medicalAppointmentId);
        }
        addDataToResultMap("medicalAppointmentMedicament",medicalAppointmentMedicament);
    }
}
