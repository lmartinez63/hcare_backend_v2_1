package com.landl.hcare.service;

import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.MedicalAppointmentMedicament;

import java.util.List;

public interface MedicalAppointmentMedicamentService {

    public MedicalAppointmentMedicament save(MedicalAppointmentMedicament medicalAppointmentMedicament) throws Exception;

    public List<MedicalAppointmentMedicament> findAll() throws Exception;

    public MedicalAppointmentMedicament findById(Long medicalAppointmentMedicamentId) throws Exception;

    public MedicalAppointmentMedicament createMedicalAppointmentMedicament(Long medicalAppointmentId) throws  Exception;
    
    public void getObjectLabeled(MedicalAppointmentMedicament medicalAppointmentMedicament) throws Exception;

}
