package com.landl.hcare.controller;

import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.MedicalHistory;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DashboardController {

    @Autowired
    private MedicalAppointmentService medicalAppointmentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private EmailTemplateService emailTemplateService;


    @Autowired
    private EmailService emailService;

    @Autowired
    private MedicalHistoryService medicalHistoryService;

    @GetMapping("/getDashboardInformation")
    public Map retrieveByMedicalAppointmentId() throws Exception{
        Map<String,Object> requiredInformation = new HashMap<String,Object>();
        //Geting MedicalAppointments per day
        Long qtyMedAppPerDay =  medicalAppointmentService.countByDateAppointment(new Date());
        requiredInformation.put("qtyMedAppPerDay",qtyMedAppPerDay);
        //Geting MedicalAppointments Attended per day
        Long qtyMedAppAttendedPerDay =  medicalAppointmentService.countByStatusAndDateAppointment("10",new Date());
        requiredInformation.put("qtyMedAppAttendedPerDay",qtyMedAppAttendedPerDay);

        //Geting MedicalAppointments Attended per day
        Long qtyMedAppNotAttendedPerDay =  medicalAppointmentService.countByStatusAndDateAppointment("90",new Date());
        requiredInformation.put("qtyMedAppNotAttendedPerDay",qtyMedAppNotAttendedPerDay);

        return requiredInformation;
    }



}
