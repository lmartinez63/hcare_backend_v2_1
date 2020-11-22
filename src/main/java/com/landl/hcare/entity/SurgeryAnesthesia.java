package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Audited
@Table(name="surgery_anesthesia")
public class SurgeryAnesthesia extends AuditModel {
    @Id
    @GeneratedValue(generator = "surgery_anesthesia_generator")
    @SequenceGenerator(
            name = "surgery_anesthesia_generator",
            sequenceName = "surgery_anesthesia_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="anesthesiologist_id")
    private Long anesthesiologistId;

    @Transient
    private UserProfile anesthesiologist;

    @Transient
    private String anesthesiologistFullName;

    @Transient
    private Patient patient;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="anesthesia_report_id")
    private Attachment anesthesiaReport;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="post_anesthesia_report_id")
    private Attachment postAnesthesiaReport;

    @Column(name="medical_surgery_id")
    @Audited
    private Long medicalSurgeryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnesthesiologistId() {
        return anesthesiologistId;
    }

    public void setAnesthesiologistId(Long anesthesiologistId) {
        this.anesthesiologistId = anesthesiologistId;
    }

    public UserProfile getAnesthesiologist() {
        return anesthesiologist;
    }

    public void setAnesthesiologist(UserProfile anesthesiologist) {
        this.anesthesiologist = anesthesiologist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Attachment getAnesthesiaReport() {
        return anesthesiaReport;
    }

    public void setAnesthesiaReport(Attachment anesthesiaReport) {
        this.anesthesiaReport = anesthesiaReport;
    }

    public Attachment getPostAnesthesiaReport() {
        return postAnesthesiaReport;
    }

    public void setPostAnesthesiaReport(Attachment postAnesthesiaReport) {
        this.postAnesthesiaReport = postAnesthesiaReport;
    }

    public Long getMedicalSurgeryId() {
        return medicalSurgeryId;
    }

    public void setMedicalSurgeryId(Long medicalSurgeryId) {
        this.medicalSurgeryId = medicalSurgeryId;
    }

    public String getAnesthesiologistFullName() {
        return anesthesiologistFullName;
    }

    public void setAnesthesiologistFullName(String anesthesiologistFullName) {
        if(this.anesthesiologist != null)
        this.anesthesiologistFullName = this.anesthesiologist.getFullName();
    }
}
