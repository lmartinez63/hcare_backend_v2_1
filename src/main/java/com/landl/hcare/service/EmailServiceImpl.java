package com.landl.hcare.service;


import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.*;
import com.landl.hcare.entity.type.MedicalAppointmentStatus;
import com.landl.hcare.repository.EmailRepository;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public Configuration freemarkerConfig;

    @Autowired
    public UtilityTools utilityTools;

    @Autowired
    public EmailTemplateService emailTemplateService;

    @Autowired
    public PatientService patientService;

    @Autowired
    public UserService userService;

    @Autowired
    public PropertyService propertyService;

    @Autowired
    EmailRepository emailRepository;

    public void sendSimpleMessage(Email email) throws Exception{
        MimeMessage message = emailSender.createMimeMessage();
        // pass 'true' to the constructor to create a multipart message
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String uniqueEmailTo = propertyService.getPropertyValue("uniqueEmailTo");
        if(uniqueEmailTo != null){
            helper.setTo(uniqueEmailTo);
        } else {
            helper.setTo(email.getSendTo());
        }
        //TODO put bcc in a property
        helper.setBcc("l.martinez.rod@gmail.com");
        helper.setSubject(email.getSubject());
        helper.setText(email.getBody(), true);
        if(email.getAttachmentList() != null){
            for (Attachment attachment : email.getAttachmentList()) {
                helper.addAttachment(attachment.getFileTitle(), new ByteArrayResource(attachment.getContent())); }
        }

        emailSender.send(message);
    }

    public void buildEmailFromEmailTemplate(Email email) throws Exception {
        EmailTemplate emailTemplate = email.getEmailTemplate();
        Map<String, Object> dataSource = email.getDataSource();
        if (emailTemplate.getSendTo() != null && emailTemplate.getSendTo().contains("{{")) {
            email.setSendTo(UtilityTools.getFormatedValue(emailTemplate.getSendTo(), dataSource));
        }
        if (emailTemplate.getSendFrom() != null && emailTemplate.getSendFrom().contains("{{")) {
            email.setSendFrom(UtilityTools.getFormatedValue(emailTemplate.getSendFrom(), dataSource));
        }
        if (emailTemplate.getSubject() != null && emailTemplate.getSubject().contains("{{")) {
            email.setSubject(UtilityTools.getFormatedValue(emailTemplate.getSubject(), dataSource));
        }

        // Using a subfolder such as /templates here
        freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
        freemarkerConfig.setObjectWrapper( new DefaultObjectWrapper() );
        Map<String, Object> datasource = email.getDataSource();
        Template t = freemarkerConfig.getTemplate(emailTemplate.getTemplateFileName());
        String textTemplate = FreeMarkerTemplateUtils.processTemplateIntoString(t, datasource);
        email.setBody(textTemplate);
    }


    /* Repository Methods*/

    public Email save(Email email){
        return emailRepository.save(email);
    }

    public List<Email> findAll(){
        return emailRepository.findAll();
    }
    public List<Email> findByStatus(Integer status){
        return emailRepository.findByStatus(status);
    }

    public Optional<Email> findById(Long emailId){
        return emailRepository.findById(emailId);
    }

    public int sendEmailToPatient(MedicalAppointment medicalAppointment) throws Exception{
        // email to Patient
        EmailTemplate emailTemplate = null;
        switch (medicalAppointment.getStatus()){
            case MedicalAppointmentStatus.NEW:
                emailTemplate = emailTemplateService.findByTemplateType("newMedicalAppointmentToPatient");
                break;
            default:
                return 50;
        }
        Email email = new Email();
        email.setStatus(0);
        email.setEmailTemplate(emailTemplate);
        //Get Data source
        Map<String,Object> dataSource = new HashMap<String, Object>();
        Map<String, Object> propertiesMap =  propertyService.getPropertiesMap();
        UserProfile doctor = userService.findById(medicalAppointment.getDoctorId());
        dataSource.put("Properties", propertiesMap);
        dataSource.put("Doctor", doctor);
        dataSource.put("MedicalAppointment", medicalAppointment);
        email.setDataSource(dataSource);
        buildEmailFromEmailTemplate(email);
        save(email);
        return 100;
    }

    public int sendEmailToDoctor(MedicalAppointment medicalAppointment) throws Exception{
        // email to Patient
        EmailTemplate emailTemplate = null;
        switch (medicalAppointment.getStatus()){
            case 0:
                emailTemplate = emailTemplateService.findByTemplateType("newMedicalAppointmentToDoctor");
                break;
            default:
                return 50;
        }
        Email email = new Email();
        email.setStatus(0);
        email.setEmailTemplate(emailTemplate);
        //Get Data source
        try {
            Map<String, Object> dataSource = new HashMap<String, Object>();
            UserProfile doctor = userService.findById(medicalAppointment.getDoctorId());
            Map<String, Object> propertiesMap = propertyService.getPropertiesMap();
            dataSource.put("Properties", propertiesMap);
            dataSource.put("Doctor", doctor);
            dataSource.put("MedicalAppointment", medicalAppointment);
            email.setDataSource(dataSource);
            buildEmailFromEmailTemplate(email);
        } catch(Exception e){
            e.printStackTrace();
            String errorMessage = "";
            if(e.getMessage() != null && e.getMessage().length() > 10485758){
                errorMessage = e.getMessage().substring(0,10485758);
            } else {
                errorMessage = UtilityTools.isNull(e.getMessage());
            }
            email.setMessageError(errorMessage);
            email.setStatus(99);
        }
        save(email);
        return 100;
    }
}