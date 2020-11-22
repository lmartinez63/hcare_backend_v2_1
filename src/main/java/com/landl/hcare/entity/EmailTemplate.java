package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;

import javax.persistence.*;

@Entity
@Table(name="email_template")
public class EmailTemplate  extends AuditModel {
    @Id
    @GeneratedValue(generator = "email_template_generator")
    @SequenceGenerator(
            name = "email_template_generator",
            sequenceName = "email_template_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="template_type")
    private String templateType;

    @Column(name="send_to")
    private String sendTo;

    @Column(name="send_from")
    private String sendFrom;

    @Column(name="subject")
    private String subject;

    @Column(name="template_file_name")
    private String templateFileName;

    @Column(name="frequency")
    private String frequency;

    public EmailTemplate() {
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSendFrom() {
        return sendFrom;
    }

    public void setSendFrom(String sendFrom) {
        this.sendFrom = sendFrom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplateFileName() {
        return templateFileName;
    }

    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
