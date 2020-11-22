package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Directory;
import com.landl.hcare.entity.ExamBundle;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.service.ExamBundleService;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component("retrieveMedicalAppointmentInfo")
public class RetrieveMedicalAppointmentInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_medicalAppointmentId = (String)requestMap.get("medicalAppointmentId");
        MedicalAppointment medicalAppointment;
        if(s_medicalAppointmentId != null) {
            Long l_medicalAppointmentId = Long.parseLong(s_medicalAppointmentId);
            medicalAppointment = medicalAppointmentService.findById(l_medicalAppointmentId);
            //TODO change to correct change
            //medicalAppointment.setLabelStatus(labelService.getByLabelCodeAndUserLanguage(medicalAppointment.getStatus().toString(),"MEDICAL_APPOINTMENT","STATUS").getLabelValueEsEs());
            medicalAppointmentService.getObjectLabeled(medicalAppointment);
            if (medicalAppointment.getAllergies()!= null && medicalAppointment.getAllergies().compareTo("null") != 0){
                medicalAppointment.setAllergiesArray(ArrayUtils.toObject(Arrays.stream(medicalAppointment.getAllergies().substring(1, medicalAppointment.getAllergies().length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray()));
            }
            if (medicalAppointment.getPathologicalBackground()!= null && medicalAppointment.getPathologicalBackground().compareTo("null") != 0){
                medicalAppointment.setPathologicalBackgroundArray(ArrayUtils.toObject(Arrays.stream(medicalAppointment.getPathologicalBackground().substring(1, medicalAppointment.getPathologicalBackground().length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray()));
            }
            if (medicalAppointment.getDefinitiveCoherent()!= null && medicalAppointment.getDefinitiveCoherent().compareTo("null") != 0){
                medicalAppointment.setDefinitiveCoherentArray(ArrayUtils.toObject(Arrays.stream(medicalAppointment.getDefinitiveCoherent().substring(1, medicalAppointment.getDefinitiveCoherent().length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray()));
            }
            Directory directory = directoryService.findByEntityNameAndParentDirectoryIdIsNull("medical_appointment");
            directoryService.retrieveAttachmentInformation(directory,String.valueOf(medicalAppointment.getId()));
            medicalAppointment.setFiles(directoryService.convertDirectoryToFrontEndFormat(directory));
            
        } else {
            medicalAppointment = medicalAppointmentService.createMedicalAppointment();
            //Create new additional medical appointment
            if (requestMap.containsKey("parentMedicalAppointmentId")){
                Integer i_parentMedicalAppointmentId = (Integer)requestMap.get("parentMedicalAppointmentId");
                Integer i_doctorId = (Integer)requestMap.get("doctorId");
                medicalAppointment.setParentMedicalAppointmentId(i_parentMedicalAppointmentId.longValue());
                medicalAppointment.setDoctorId(i_doctorId.longValue());
            }
        }
        addDataToResultMap("medicalAppointment",medicalAppointment);
    }



}
