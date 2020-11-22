package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;

import javax.persistence.*;
import java.util.Date;
import java.util.Map;

@Entity
@Table(name="attachment")
public class Attachment extends AuditModel {
    @Id
    @GeneratedValue(generator = "attachment_generator")
    @SequenceGenerator(
            name = "attachment_generator",
            sequenceName = "attachment_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="content")
    private byte[] content;

    @Column(name="content_type")
    private String contentType;

    @Column(name="email_id")
    private Long emailId;

    @Column(name="entity_id")
    private Long entityId;

    @Column(name="entity")
    private String entity;

    @Transient
    private String fieldToMatchEntiyId;

    @Column(name="internal_file_name")
    private String internalFileName;

    @Column(name="file_title")
    private String fileTitle;

    public Attachment() {
    }

    public Attachment(String fileTitle, String entity, Long entityId) {
        this.entity = entity;
        this.entityId = entityId;
        this.fileTitle = fileTitle;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    public String getInternalFileName() {
        return internalFileName;
    }

    public void setInternalFileName(String internalFileName) {
        this.internalFileName = internalFileName;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFieldToMatchEntiyId() {
        return fieldToMatchEntiyId;
    }

    public void setFieldToMatchEntiyId(String fieldToMatchEntiyId) {
        this.fieldToMatchEntiyId = fieldToMatchEntiyId;
    }
}
