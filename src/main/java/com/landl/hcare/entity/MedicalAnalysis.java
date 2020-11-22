package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Audited
@Table(name="medical_analysis")
public class MedicalAnalysis extends AuditModel {
    @Id
    @GeneratedValue(generator = "medical_analysis_generator")
    @SequenceGenerator(
            name = "medical_analysis_generator",
            sequenceName = "medical_analysis_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="analysis_type")
    @Audited
    private Integer analysisType;

    @Transient
    private String labelAnalysisType;

    @Column(name="status")
    @Audited
    private Integer status;

    @Transient
    private String labelStatus;

    @Column(name="type")
    @Audited
    private Integer type;

    @Column(name="required_date")
    @Audited
    private Date requiredDate;

    @Column(name="uploaded_date")
    @Audited
    private Date uploadedDate;

    @Column(name="internal_medical_area_id")
    @Audited
    private Long internalMedicalAreaId;

    @Column(name="internal_doctor_id")
    @Audited
    private Long internalDoctorId;

    @Column(name="comentaries", nullable = true, length = 4000)
    @Audited
    private String comentaries;

    @Column(name="result", nullable = true, length = 4000)
    @Audited
    private String result;

    @Column(name="medical_surgery_id")
    private Long medicalSurgeryId;

    //Format for directories frontEnd
    @Transient
    @NotAudited
    private List<Map> files;

    public MedicalAnalysis() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnalysisType() {
        return analysisType;
    }

    public void setAnalysisType(Integer analysisType) {
        this.analysisType = analysisType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public Long getInternalMedicalAreaId() {
        return internalMedicalAreaId;
    }

    public void setInternalMedicalAreaId(Long internalMedicalAreaId) {
        this.internalMedicalAreaId = internalMedicalAreaId;
    }

    public Long getInternalDoctorId() {
        return internalDoctorId;
    }

    public void setInternalDoctorId(Long internalDoctorId) {
        this.internalDoctorId = internalDoctorId;
    }

    public String getComentaries() {
        return comentaries;
    }

    public void setComentaries(String comentaries) {
        this.comentaries = comentaries;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getMedicalSurgeryId() {
        return medicalSurgeryId;
    }

    public void setMedicalSurgeryId(Long medicalSurgeryId) {
        this.medicalSurgeryId = medicalSurgeryId;
    }

    public List<Map> getFiles() {
        return files;
    }

    public void setFiles(List<Map> files) {
        this.files = files;
    }

    public String getLabelAnalysisType() {
        return labelAnalysisType;
    }

    public void setLabelAnalysisType(String labelAnalysisType) {
        this.labelAnalysisType = labelAnalysisType;
    }

    public String getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(String labelStatus) {
        this.labelStatus = labelStatus;
    }
}
