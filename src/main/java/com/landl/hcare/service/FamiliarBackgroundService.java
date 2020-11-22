package com.landl.hcare.service;

import com.landl.hcare.entity.FamiliarBackground;
import com.landl.hcare.entity.MedicalAppointment;

import java.util.List;

public interface FamiliarBackgroundService {

    public FamiliarBackground save(FamiliarBackground familiarBackground);

    public List<FamiliarBackground> findAll();

    public FamiliarBackground findById(Long id);
    
    public void getObjectLabeled(FamiliarBackground familiarBackground) throws Exception;
    
    public FamiliarBackground createFamiliarBackground(Long medicalAppointmentId);

}
