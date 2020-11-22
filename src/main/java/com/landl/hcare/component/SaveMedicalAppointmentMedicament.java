package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.MedicalAppointmentMedicament;
import com.landl.hcare.entity.SurgeryDoctor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveMedicalAppointmentMedicament")
public class SaveMedicalAppointmentMedicament extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final MedicalAppointmentMedicament medicalAppointmentMedicamentRequest = mapper.convertValue(requestMap.get("medicalAppointmentMedicament"), MedicalAppointmentMedicament.class);
        MedicalAppointmentMedicament medicalAppointmentMedicament = null;
        if (medicalAppointmentMedicamentRequest.getId() != null){
        	medicalAppointmentMedicament = medicalAppointmentMedicamentService.findById(medicalAppointmentMedicamentRequest.getId());
            copyNonNullProperties(medicalAppointmentMedicamentRequest, medicalAppointmentMedicament);
        } else {
        	medicalAppointmentMedicament = medicalAppointmentMedicamentRequest;
        }
        MedicalAppointmentMedicament medicalAppointmentMedicamentSaved = medicalAppointmentMedicamentService.save(medicalAppointmentMedicament);
        addDataToResultMap("medicalAppointmentMedicament",medicalAppointmentMedicamentSaved);

    }



}
