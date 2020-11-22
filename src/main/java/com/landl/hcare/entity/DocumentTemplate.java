package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;

import javax.persistence.*;

@Entity
@Table(name="document_template")
public class DocumentTemplate extends AuditModel {
    @Id
    @GeneratedValue(generator = "document_template_generator")
    @SequenceGenerator(
            name = "document_template_generator",
            sequenceName = "document_template_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="template_code")
    private String templateCode;

    @Column(name="template_file_name")
    private String templateFileName;

    @Transient
    private String outputFormat;


    public DocumentTemplate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public void setTemplateCode(String templateCode) {
        this.templateCode = templateCode;
    }

    public String getTemplateFileName() {
        return templateFileName;
    }

    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }
}
