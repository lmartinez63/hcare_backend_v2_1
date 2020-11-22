package com.landl.hcare.service;

import com.landl.hcare.entity.Attachment;
import com.landl.hcare.entity.FamiliarBackground;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.MedicalAppointmentMedicament;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.entity.type.MedicalAppointmentStatus;
import com.landl.hcare.repository.MedicalAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class MedicalAppointmentServiceImpl extends ObjectServiceImpl implements MedicalAppointmentService {

    @Autowired
    MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    PatientService patientService;
    
    @Autowired
    FamiliarBackgroundService familiarBackgroundService;
    
    @Autowired
    MedicalAppointmentMedicamentService medicalAppointmentMedicamentService;
    
    

    public MedicalAppointment save(MedicalAppointment medicalAppointment) throws Exception{
        return medicalAppointmentRepository.save(medicalAppointment);
    }

    public List<MedicalAppointment> findAll() throws Exception{
        return medicalAppointmentRepository.findAll();
    }

    public void getObjectLabeled(MedicalAppointment medicalAppointment) throws  Exception{
        transformObjectLabels(medicalAppointment);
        patientService.getObjectLabeled(medicalAppointment.getPatient());
        if(medicalAppointment.getFamiliarBackgroundList() != null && medicalAppointment.getFamiliarBackgroundList().size() > 0) {
        	for(FamiliarBackground familiarBackground:medicalAppointment.getFamiliarBackgroundList()) {
        		familiarBackgroundService.getObjectLabeled(familiarBackground);
        	}
        }
        if(medicalAppointment.getMedicalAppointmentMedicamentList() != null && medicalAppointment.getMedicalAppointmentMedicamentList().size() > 0) {
        	for(MedicalAppointmentMedicament medicalAppointmentMedicament:medicalAppointment.getMedicalAppointmentMedicamentList()) {
        		medicalAppointmentMedicamentService.getObjectLabeled(medicalAppointmentMedicament);
        	}
        }
    }

    public MedicalAppointment findById(Long medicalAppointmentId) throws Exception{
        return medicalAppointmentRepository.findById(medicalAppointmentId).get();
    }
    public MedicalAppointment createMedicalAppointment() throws  Exception{
        MedicalAppointment medicalAppointment = new MedicalAppointment();
        Patient patient = new Patient();
        //TODO it should come from database
        //DefaultValues
        medicalAppointment.setStatus(MedicalAppointmentStatus.NEW);
        medicalAppointment.setDateAppointment(new Date());
        patient.setEmailAddress("novaclinicarequipa@gmail.com");
        //TODO we Should use ENUMS
        patient.setDocumentType(1);
        medicalAppointment.setMedicalAppointmentType(1);
        medicalAppointment.setPatient(patient);
        medicalAppointment.setAttachmentList(new ArrayList<>());
        return medicalAppointment;
    }

    /*
    public List<MedicalAppointment> findByHistoryCode(Long historyCode) throws Exception{
        return medicalAppointmentRepository.findByHistoryCode(historyCode);
    }

    public List<MedicalAppointment> findByDocumentNumber(String documentNumber) throws Exception{
        return medicalAppointmentRepository.findByDocumentNumber(documentNumber);
    }
    */

    public List<MedicalAppointment> findByToday(){
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        today = cal.getTime();

        Date tomorrow = new Date();
        cal.setTime(today);
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        tomorrow = cal.getTime();
        return medicalAppointmentRepository.findByDateAppointmentBetweenOrderByDateAppointmentAsc(today,tomorrow);
    };

    public List<MedicalAppointment> findByDateAppointment(Date date){
        Date targetDate = date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        targetDate = cal.getTime();

        Date dayAfterTargetDate = new Date();
        cal.setTime(targetDate);
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        dayAfterTargetDate = cal.getTime();
        return medicalAppointmentRepository.findByDateAppointmentBetweenOrderByDateAppointmentAsc(targetDate,dayAfterTargetDate);
    };

    public List<MedicalAppointment> findByDateAppointmentAndDoctorId(Date date,Long doctorId){
        Date targetDate = date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        targetDate = cal.getTime();

        Date dayAfterTargetDate = new Date();
        cal.setTime(targetDate);
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        dayAfterTargetDate = cal.getTime();

        return medicalAppointmentRepository.findByDoctorIdAndDateAppointmentBetweenOrderByDateAppointmentAsc(doctorId,targetDate,dayAfterTargetDate);
    };

    public Long countByDateAppointment(Date date){
        Date targetDate = date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        targetDate = cal.getTime();

        Date dayAfterTargetDate = new Date();
        cal.setTime(targetDate);
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        dayAfterTargetDate = cal.getTime();
        return medicalAppointmentRepository.countByDateAppointmentBetweenOrderByDateAppointmentAsc(targetDate,dayAfterTargetDate);
    }

    public Long countByStatusAndDateAppointment(String status, Date date){
        Date targetDate = date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(targetDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        targetDate = cal.getTime();

        Date dayAfterTargetDate = new Date();
        cal.setTime(targetDate);
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        dayAfterTargetDate = cal.getTime();
        return medicalAppointmentRepository.countByStatusAndDateAppointmentBetweenOrderByDateAppointmentAsc(status,targetDate,dayAfterTargetDate);
    }
}
