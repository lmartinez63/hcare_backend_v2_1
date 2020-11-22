package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class SurgeryDoctor   extends AuditModel {

    @Id
    @GeneratedValue(generator = "surgery_doctor_generator")
    @SequenceGenerator(
            name = "surgery_doctor_generator",
            sequenceName = "surgery_doctor_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="surgery_doctor_id")
    @Audited
    private Long surgeryDoctorId;

    @Transient
    private UserProfile surgeryDoctorProfile;

    @Transient
    private String surgeryDoctorFullName;

    @Column(name="surgery_doctor_type")
    @Audited
    private Integer surgeryDoctorType;

    @Transient
    private String labelSurgeryDoctorType;

    @Column(name="medical_surgery_id")
    @Audited
    private Long medicalSurgeryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSurgeryDoctorId() {
        return surgeryDoctorId;
    }

    public void setSurgeryDoctorId(Long surgeryDoctorId) {
        this.surgeryDoctorId = surgeryDoctorId;
    }

    public Integer getSurgeryDoctorType() {
        return surgeryDoctorType;
    }

    public void setSurgeryDoctorType(Integer surgeryDoctorType) {
        this.surgeryDoctorType = surgeryDoctorType;
    }

    public Long getMedicalSurgeryId() {
        return medicalSurgeryId;
    }

    public void setMedicalSurgeryId(Long medicalSurgeryId) {
        this.medicalSurgeryId = medicalSurgeryId;
    }

    public UserProfile getSurgeryDoctorProfile() {
        return surgeryDoctorProfile;
    }

    public void setSurgeryDoctorProfile(UserProfile surgeryDoctorProfile) {
        this.surgeryDoctorProfile = surgeryDoctorProfile;
    }

    public String getSurgeryDoctorFullName() {
        return surgeryDoctorFullName;
    }

    public void setSurgeryDoctorFullName(String surgeryDoctorFullName) {
        this.surgeryDoctorFullName = surgeryDoctorFullName;
    }

    public String getLabelSurgeryDoctorType() {
        return labelSurgeryDoctorType;
    }

    public void setLabelSurgeryDoctorType(String labelSurgeryDoctorType) {
        this.labelSurgeryDoctorType = labelSurgeryDoctorType;
    }
}