package com.landl.hcare.service;

import com.landl.hcare.entity.Patient;
import com.landl.hcare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl extends ObjectServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    public Patient save(Patient patient){
        return patientRepository.save(patient);
    }

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public List<Patient> findByBirthday(Date birthday){
        return patientRepository.findByBirthday(birthday);
    };
    public Patient findByDocumentNumber(String documentNumber) throws Exception {
        Patient patient = null;
        List<Patient> patientList  =  patientRepository.findByDocumentNumber(documentNumber);
        if( patientList.size() > 0 ){
            patient = patientList.get(0);
        }
        return patient;
    };

    public Patient findById(Long patientId) throws  Exception{
        return patientRepository.findById(patientId).get();
    }

    public void getObjectLabeled(Patient patient) throws  Exception{
        transformObjectLabels(patient);
    }

    public Patient createPatient() throws  Exception{
        Patient patient = new Patient();
        //TODO it should come from database default values
        //DefaultValues
        patient.setDocumentType(1);
        patient.setBirthday(new Date());
        //0 = No specified
        patient.setGender(0);
        return patient;
    }

    public Patient findByHistoryCode(Long historyCode) throws Exception{
        Patient patient = null;
        List<Patient> patientList  =  patientRepository.findByHistoryCode(historyCode);
        if( patientList.size() > 0 ){
            patient = patientList.get(0);
        }
        return patient;
    }
}
