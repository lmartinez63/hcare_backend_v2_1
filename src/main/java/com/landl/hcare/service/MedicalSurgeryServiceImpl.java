package com.landl.hcare.service;

import com.landl.hcare.entity.*;
import com.landl.hcare.entity.type.MedicalSurgeryStatus;
import com.landl.hcare.repository.MedicalSurgeryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MedicalSurgeryServiceImpl extends ObjectServiceImpl implements MedicalSurgeryService {

    @Autowired
    MedicalSurgeryRepository medicalSurgeryRepository;

    @Autowired
    SurgeryTypeService surgeryTypeService;

    @Autowired
    PatientService patientService;

    @Autowired
    SurgeryAreaService surgeryAreaService;

    @Autowired
    EventService eventService;

    @Autowired
    MedicalAppointmentService medicalAppointmentService;

    public MedicalSurgery save(MedicalSurgery medicalAppointment) throws Exception{
        return medicalSurgeryRepository.save(medicalAppointment);
    }

    public List<MedicalSurgery> findAll() throws Exception{
        return medicalSurgeryRepository.findAll();
    }

    public MedicalSurgery findById(Long medicalAppointmentId) throws Exception{
        return medicalSurgeryRepository.findById(medicalAppointmentId).get();
    }

    public void getObjectLabeled(MedicalSurgery medicalSurgery) throws Exception{
        transformObjectLabels(medicalSurgery);
        medicalAppointmentService.getObjectLabeled(medicalSurgery.getMedicalAppointment());
    }

    public MedicalSurgery createMedicalSurgery(MedicalAppointment medicalAppointment) throws  Exception{
        MedicalSurgery medicalSurgery = new MedicalSurgery();
        medicalSurgery.setStatus(MedicalSurgeryStatus.PENDING);
        medicalSurgery.setMedicalAppointment(medicalAppointment);
        return medicalSurgery;
    }
    public List<Event> findTimeAvailableSurgeryArea(Long surgeryAreaId, Long surgeryTypeId, Date requiredDate) throws Exception{
        List<Date> dateList = new ArrayList<Date>();
        SurgeryType surgeryType = surgeryTypeService.findById(surgeryTypeId);
        SurgeryArea surgeryArea = surgeryAreaService.findById(surgeryAreaId);
        List<Event> dateTimeAvailable = eventService.getAvailableDatetimesInSurgeryArea(requiredDate, surgeryAreaId, surgeryType.getDurationMinutes());
        return dateTimeAvailable;
    }

    public List<Event> findTimeAvailableBySurgeryType(Long surgeryTypeId, Date requiredDate) throws Exception{
        List<Date> dateList = new ArrayList<Date>();
        SurgeryType surgeryType = surgeryTypeService.findById(surgeryTypeId);
        List<Event> dateTimeAvailable = eventService.getAvailableDatetimesBySurgeryType(requiredDate, surgeryType.getDurationMinutes());
        return dateTimeAvailable;
    }
}
