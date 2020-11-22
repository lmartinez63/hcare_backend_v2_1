package com.landl.hcare.entity;

import org.hibernate.envers.Audited;

import javax.persistence.*;

@Entity
@Audited
public class SurgeryNurse {

    @Id
    @GeneratedValue(generator = "surgery_nurse_generator")
    @SequenceGenerator(
            name = "surgery_nurse_generator",
            sequenceName = "surgery_nurse_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="surgery_nurse_id")
    @Audited
    private Long surgeryNurseId;

    @Transient
    private UserProfile surgeryNurseProfile;

    @Transient
    private String surgeryNurseFullName;

    @Column(name="surgery_nurse_type")
    @Audited
    private Integer surgeryNurseType;

    @Transient
    private String labelSurgeryNurseType;

    @Column(name="medical_surgery_id")
    @Audited
    private Long medicalSurgeryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSurgeryNurseId() {
        return surgeryNurseId;
    }

    public void setSurgeryNurseId(Long surgeryNurseId) {
        this.surgeryNurseId = surgeryNurseId;
    }

    public Integer getSurgeryNurseType() {
        return surgeryNurseType;
    }

    public void setSurgeryNurseType(Integer surgeryNurseType) {
        this.surgeryNurseType = surgeryNurseType;
    }

    public Long getMedicalSurgeryId() {
        return medicalSurgeryId;
    }

    public void setMedicalSurgeryId(Long medicalSurgeryId) {
        this.medicalSurgeryId = medicalSurgeryId;
    }

    public UserProfile getSurgeryNurseProfile() {
        return surgeryNurseProfile;
    }

    public void setSurgeryNurseProfile(UserProfile surgeryNurseProfile) {
        this.surgeryNurseProfile = surgeryNurseProfile;
    }

    public String getSurgeryNurseFullName() {
        return surgeryNurseFullName;
    }

    public void setSurgeryNurseFullName(String surgeryNurseFullName) {
        this.surgeryNurseFullName = surgeryNurseFullName;
    }

    public String getLabelSurgeryNurseType() {
        return labelSurgeryNurseType;
    }

    public void setLabelSurgeryNurseType(String labelSurgeryNurseType) {
        this.labelSurgeryNurseType = labelSurgeryNurseType;
    }
}