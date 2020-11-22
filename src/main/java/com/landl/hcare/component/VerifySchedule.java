package com.landl.hcare.component;

import com.landl.hcare.entity.*;
import com.landl.hcare.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

@Component("verifySchedule")
public class VerifySchedule {

    private static final Logger LOGGER = LogManager.getLogger(VerifySchedule.class.getName());

    @Autowired
    EmailTemplateService emailTemplateService;

    @Autowired
    EmailService emailService;

    @Autowired
    PatientService patientService;

    @Autowired
    UserService userService;

    @Autowired
    MedicalAppointmentService medicalAppointmentService;

    public void executeTask(){
        LOGGER.debug("Executing task");
        try
        {
            //for(EmailQueue emailQueue : emailQueueRepository.findByIStatus(0)){
            for (EmailTemplate emailTemplate : emailTemplateService.findAll()) {
                LOGGER.info("Processing emailTemplate" + emailTemplate.toString());
                Calendar c = Calendar.getInstance();
                c.set(Calendar.HOUR_OF_DAY, 0);
                c.set(Calendar.MINUTE, 0);
                c.set(Calendar.SECOND, 0);
                c.set(Calendar.MILLISECOND, 0);
                Date today = c.getTime();
                switch (emailTemplate.getTemplateType()){
                    case "birthdayEmail":
                        LOGGER.info("Processing birthdayEmail Template" + emailTemplate.toString());
                        List<Patient> patientList = patientService.findByBirthday(today);
                        for(Patient patient:patientList){
                            Email email = new Email();
                            email.setStatus(0);
                            email.setEmailTemplate(emailTemplate);
                            //Get Data source
                            Map<String,Object> dataSource = new HashMap<String, Object>();
                            dataSource.put("Patient", patient);
                            LOGGER.info("Getting datasource");
                            email.setDataSource(dataSource);
                            LOGGER.info("Building Email");
                            emailService.buildEmailFromEmailTemplate(email);
                            LOGGER.info("Email Saved");
                            emailService.save(email);
                        }
                        break;
                    case "medicalAppointmentReportByDoctor":
                    LOGGER.info("Processing medicalAppointmentReportByDoctor Template" + emailTemplate.toString());
                    List<UserProfile> doctorsList = userService.findByRole("DOCTOR");
                    for(UserProfile doctor:doctorsList){

                        Calendar cal = Calendar.getInstance();
                        Date tomorrow = new Date();
                        cal.setTime(tomorrow);
                        cal.add(Calendar.DATE, 1);
                        cal.set(Calendar.HOUR_OF_DAY, 0);
                        cal.set(Calendar.MINUTE, 0);
                        cal.set(Calendar.SECOND, 0);
                        cal.set(Calendar.MILLISECOND, 0);
                        tomorrow = cal.getTime();
                        List<MedicalAppointment> medicalAppointmentList = medicalAppointmentService.findByDateAppointmentAndDoctorId(tomorrow, doctor.getId());
                        if (medicalAppointmentList != null && medicalAppointmentList.size() > 0) {
                            Email email = new Email();
                            email.setStatus(0);
                            email.setEmailTemplate(emailTemplate);
                            //Get Data source
                            Map<String, Object> dataSource = new HashMap<String, Object>();
                            dataSource.put("doctor", doctor);
                            dataSource.put("mal", medicalAppointmentList);
                            LOGGER.info("Getting datasource");
                            email.setDataSource(dataSource);
                            LOGGER.info("Building Email");
                            emailService.buildEmailFromEmailTemplate(email);
                            LOGGER.info("Email Saved");
                            emailService.save(email);
                        }
                    }
                    break;
                    default:
                        break;
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
            LOGGER.error("There is a error ");
        }
        LOGGER.debug("Task Finished");
    }

}
