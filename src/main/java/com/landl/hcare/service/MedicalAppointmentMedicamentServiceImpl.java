package com.landl.hcare.service;
import com.landl.hcare.entity.FamiliarBackground;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.MedicalAppointmentMedicament;
import com.landl.hcare.repository.MedicalAppointmentMedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalAppointmentMedicamentServiceImpl extends ObjectServiceImpl implements MedicalAppointmentMedicamentService {

    @Autowired
    MedicalAppointmentMedicamentRepository medicalAppointmentMedicamentRepository;

    public MedicalAppointmentMedicament save(MedicalAppointmentMedicament medicalAppointmentMedicament) throws Exception{
        return medicalAppointmentMedicamentRepository.save(medicalAppointmentMedicament);
    }

    public List<MedicalAppointmentMedicament> findAll() throws Exception{
        return medicalAppointmentMedicamentRepository.findAll();
    }

    public MedicalAppointmentMedicament findById(Long medicalAppointmentMedicamentId) throws Exception{
        return medicalAppointmentMedicamentRepository.findById(medicalAppointmentMedicamentId).get();
    }

    public MedicalAppointmentMedicament createMedicalAppointmentMedicament(Long medicalAppointmentId) throws  Exception{
    	MedicalAppointmentMedicament medicalAppointmentMedicament = new MedicalAppointmentMedicament();
    	medicalAppointmentMedicament.setMedicalAppointmentId(medicalAppointmentId);
        return medicalAppointmentMedicament;
    }
    
    public void getObjectLabeled(MedicalAppointmentMedicament medicalAppointmentMedicament) throws  Exception{
        transformObjectLabels(medicalAppointmentMedicament);
    }
    
}
