package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.AuxiliarExam;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.MedicalHistory;
import com.landl.hcare.entity.MedicalSurgery;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.entity.type.MedicalAppointmentStatus;

import io.jsonwebtoken.lang.Collections;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;

@Component("saveMedicalAppointment")
public class SaveMedicalAppointment extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final MedicalAppointment medicalAppointmentRequest = mapper.convertValue(requestMap.get("medicalAppointment"), MedicalAppointment.class);
        Integer originalStatus = null;
        MedicalAppointment medicalAppointment = null;
        if (medicalAppointmentRequest.getId() != null){
            medicalAppointment = medicalAppointmentService.findById(medicalAppointmentRequest.getId());
            originalStatus = medicalAppointment.getStatus();
            copyNonNullProperties(medicalAppointmentRequest, medicalAppointment);
        } else {
            medicalAppointment = medicalAppointmentRequest;
        }
        medicalAppointment.setAllergies(Arrays.toString(medicalAppointment.getAllergiesArray()));
        medicalAppointment.setDefinitiveCoherent(Arrays.toString(medicalAppointment.getDefinitiveCoherentArray()));
        medicalAppointment.setPathologicalBackground(Arrays.toString(medicalAppointment.getPathologicalBackgroundArray()));
        //medicalAppointment.setAuxiliarExams(new HashSet<AuxiliarExam>(medicalAppointment.getAuxiliarExamList()));
        //Update patient fields
        /*
        Patient patient = patientService.findByDocumentNumber(medicalAppointment.getDocumentNumber());
        //Create patient if doesn't exits
        if(patient == null){
            patient = patientService.createPatient(medicalAppointment);
        } else
        {
            patient = patientService.updatePatient(patient,medicalAppointment);
        }
        patient = patientService.save(patient);
        */
        //Update Patient Information
        Patient patient = medicalAppointment.getPatient();
        patient = patientService.save(patient);
        medicalAppointment.setPatient(patient);

        //Send Notifications
        if (medicalAppointment.getId() == null) {
            //If is a new medical appointment send a reminder email
            int emailPatientStatus = emailService.sendEmailToPatient(medicalAppointment);
            int emailDoctorStatus = emailService.sendEmailToDoctor(medicalAppointment);
            medicalAppointment.setStatus(MedicalAppointmentStatus.SCHEDULED);
        }

        //Create history code if doesn't exits
        if (medicalAppointment.getStatus().compareTo(MedicalAppointmentStatus.IN_ATENTION)==0){
            medicalAppointment.setDateAttention(new Date());
            if (medicalAppointment.getPatient().getHistoryCode() == null){
                //Create Medical History set incoming patient with historyCode
                MedicalHistory medicalHistory = medicalHistoryService.createMedicalHistory(medicalAppointment.getPatient());
            }
        }
        if (medicalAppointment.getStatus().compareTo(MedicalAppointmentStatus.IN_ATENTION)==0){
            medicalAppointment.setDateAttention(new Date());
            if (medicalAppointment.getPatient().getHistoryCode() == null){
                //Create Medical History set incoming patient with historyCode
                MedicalHistory medicalHistory = medicalHistoryService.createMedicalHistory(medicalAppointment.getPatient());
            }
        }
        //
        if (medicalAppointment.getStatus().compareTo(MedicalAppointmentStatus.OPERATION_REQUEST)==0 && originalStatus.compareTo(MedicalAppointmentStatus.IN_ATENTION)==0){
            MedicalSurgery medicalSurgery = medicalSurgeryService.createMedicalSurgery(medicalAppointment);
            medicalSurgeryService.save(medicalSurgery);
        }

        //Actualizando Cita
        MedicalAppointment medicalAppointmentSaved = medicalAppointmentService.save(medicalAppointment);
        //Not neccesary
        //medicalAppointmentSaved.setAttachmentList(attachmentService.findByEntityAndEntityId("medicalAppointment", medicalAppointmentSaved.getId()));

        addDataToResultMap("medicalAppointment",medicalAppointmentSaved);

    }



}
