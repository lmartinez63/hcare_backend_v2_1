package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("retrieveMedicalSurgeryInfo")
public class RetrieveMedicalSurgeryInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_medicalSurgeryId = (String)requestMap.get("medicalSurgeryId");
        MedicalSurgery medicalSurgery = null;
        if(s_medicalSurgeryId != null){
            Long l_medicalSurgeryId = Long.parseLong(s_medicalSurgeryId);
            medicalSurgery = medicalSurgeryService.findById(l_medicalSurgeryId);
            medicalSurgery.setLabelStatus(labelService.getByLabelCodeAndUserLanguage(medicalSurgery.getStatus().toString(),"MEDICAL_SURGERY","STATUS").getLabelValueEsEs());
            if (medicalSurgery.getMedicalAnalysisList() != null && medicalSurgery.getMedicalAnalysisList().size() > 0){
               for(MedicalAnalysis medicalAnalysis:medicalSurgery.getMedicalAnalysisList()){
                   medicalAnalysis.setLabelStatus(labelService.getByLabelCodeAndUserLanguage(medicalAnalysis.getStatus().toString(),"MEDICAL_ANALYSIS","STATUS").getLabelValueEsEs());
                   if(medicalAnalysis.getAnalysisType() != null) {
                       medicalAnalysis.setLabelAnalysisType(labelService.getByLabelCodeAndUserLanguage(medicalAnalysis.getAnalysisType().toString(), "MEDICAL_ANALYSIS", "ANALYSIS_TYPE").getLabelValueEsEs());
                   }
               }
            }
            if (medicalSurgery.getSurgeryDoctors() != null && medicalSurgery.getSurgeryDoctors().size() > 0){
                for(SurgeryDoctor surgeryDoctor:medicalSurgery.getSurgeryDoctors()){
                    surgeryDoctor.setSurgeryDoctorProfile(userService.findById(surgeryDoctor.getSurgeryDoctorId()));
                    if (surgeryDoctor.getSurgeryDoctorProfile() != null){
                        surgeryDoctor.setSurgeryDoctorFullName(surgeryDoctor.getSurgeryDoctorProfile().getFullName());
                    }
                    if(surgeryDoctor.getSurgeryDoctorType() != null) {
                        surgeryDoctor.setLabelSurgeryDoctorType(labelService.getByLabelCodeAndUserLanguage(surgeryDoctor.getSurgeryDoctorType().toString(), "SURGERY_DOCTOR", "TYPE").getLabelValueEsEs());
                    }
                }
            }
            if (medicalSurgery.getSurgeryNurses() != null && medicalSurgery.getSurgeryNurses().size() > 0){
                for(SurgeryNurse surgeryNurse:medicalSurgery.getSurgeryNurses()){
                    surgeryNurse.setSurgeryNurseProfile(userService.findById(surgeryNurse.getSurgeryNurseId()));
                    if (surgeryNurse.getSurgeryNurseProfile() != null){
                        surgeryNurse.setSurgeryNurseFullName(surgeryNurse.getSurgeryNurseProfile().getFullName());
                    }
                    if(surgeryNurse.getSurgeryNurseType() != null) {
                        surgeryNurse.setLabelSurgeryNurseType(labelService.getByLabelCodeAndUserLanguage(surgeryNurse.getSurgeryNurseType().toString(), "SURGERY_NURSE", "TYPE").getLabelValueEsEs());
                    }
                }
            }
            if (medicalSurgery.getSurgeryAnesthesia() == null){
                SurgeryAnesthesia surgeryAnesthesia = surgeryAnesthesiaService.createSurgeryAnesthesia(medicalSurgery.getId());
                SurgeryAnesthesia surgeryAnesthesiaSaved = surgeryAnesthesiaService.save(surgeryAnesthesia);
                medicalSurgery.setSurgeryAnesthesia(surgeryAnesthesiaSaved);
            }
        } else {
            String s_medicalAppintmentId = (String)requestMap.get("medicalAppointmentId");
            Long l_medicalAppintmentId = Long.parseLong(s_medicalAppintmentId);
            medicalSurgery = medicalSurgeryService.createMedicalSurgery(medicalAppointmentService.findById(l_medicalAppintmentId));
        }
        addDataToResultMap("medicalSurgery",medicalSurgery);
    }
}
