package com.landl.hcare.component;

import com.landl.hcare.entity.Email;
import com.landl.hcare.service.EmailService;
import com.landl.hcare.service.EmailTemplateService;
import com.landl.hcare.service.PatientService;
import com.landl.hcare.service.PropertyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component("verifyEmail")
public class VerifyEmail {

    private static final Logger LOGGER = LogManager.getLogger(VerifyEmail.class.getName());

    @Autowired
    EmailTemplateService emailTemplateService;

    @Autowired
    EmailService emailService;

    @Autowired
    PatientService patientService;

    @Autowired
    PropertyService propertyService;

    public void executeTask(){
        LOGGER.debug("Executing task");
        try
        {
            //for(EmailQueue emailQueue : emailQueueRepository.findByIStatus(0)){
            for (Email email : emailService.findByStatus(0)) {
                LOGGER.info("Processing emails" + email.toString());
                try {
                    emailService.sendSimpleMessage(email);
                    email.setStatus(10);
                    email.setDescriptionStatus("Sucessfully sent");
                }
                catch (Exception innerException) {
                    email.setStatus(99);
                    email.setDescriptionStatus("Error: "+innerException.getMessage());
                    throw innerException;
                }
                finally {
                    emailService.save(email);
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
