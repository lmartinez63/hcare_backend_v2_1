package com.landl.hcare.service;

import com.landl.hcare.entity.Event;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.MedicalSurgery;

import java.util.Date;
import java.util.List;

public interface MedicalSurgeryService {

    public MedicalSurgery save(MedicalSurgery medicalSurgery) throws Exception;

    public List<MedicalSurgery> findAll() throws Exception;

    public MedicalSurgery findById(Long medicalSurgeryId) throws Exception;

    public void getObjectLabeled(MedicalSurgery medicalSurgery) throws Exception;

    public MedicalSurgery createMedicalSurgery(MedicalAppointment medicalAppointment) throws  Exception;

    public List<Event> findTimeAvailableSurgeryArea(Long surgeryAreaId, Long surgeryTypeId, Date requiredDate) throws Exception;

    public List<Event> findTimeAvailableBySurgeryType(Long surgeryTypeId, Date requiredDate) throws Exception;


}
