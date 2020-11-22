package com.landl.hcare.component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.MedicalSurgery;
import com.landl.hcare.entity.type.MedicalAppointmentStatus;
import com.landl.hcare.entity.type.MedicalSurgeryStatus;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveMedicalSurgery")
public class SaveMedicalSurgery extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final MedicalSurgery medicalSurgeryRequest = mapper.convertValue(requestMap.get("medicalSurgery"), MedicalSurgery.class);
        MedicalSurgery medicalSurgery = null;
        Integer originalStatus = null;
        if (medicalSurgeryRequest.getId() != null){
            medicalSurgery = medicalSurgeryService.findById(medicalSurgeryRequest.getId());
            originalStatus = medicalSurgery.getStatus();
            copyNonNullProperties(medicalSurgeryRequest, medicalSurgery);
            if( medicalSurgery.getSurgeryAreaId() != null ){
                medicalSurgery.setSurgeryArea(surgeryAreaService.findById(medicalSurgery.getSurgeryAreaId()));
            }
            //Update Medical Appointment Status once medicalSurgery is scheduled Automatically by Merge
            if (originalStatus.compareTo(MedicalSurgeryStatus.TO_CONFIRM)==0 && medicalSurgery.getStatus().compareTo(MedicalSurgeryStatus.SCHEDULED)==0 ){
                MedicalAppointment medicalAppointment = medicalSurgery.getMedicalAppointment();
                medicalAppointment.setStatus(MedicalAppointmentStatus.OPERATION_SCHEDULED);
//                medicalAppointmentService.save(medicalAppointment);
            }
        } else {
            medicalSurgery = medicalSurgeryRequest;
        }
        MedicalSurgery medicalSurgerySaved = medicalSurgeryService.save(medicalSurgery);
        addDataToResultMap("medicalSurgery",medicalSurgerySaved);

    }



}
