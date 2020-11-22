package com.landl.hcare.entity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Audited
@Table(name="medical_history")
public class MedicalHistory extends AuditModel {
    @Id
    @GeneratedValue(generator = "history_code_generator")
    @SequenceGenerator(
            name = "history_code_generator",
            sequenceName = "history_code_sequence",
            initialValue = 2500,
            allocationSize = 1
    )
    private Long historyCode;

    @Column(name="old_history_code")
    private String oldHistoryCode;


    @Column(name="file_number")
    private String fileNumber;

    @Column(name="status")
    private String status;

    @Column(name="history_activity")
    private Boolean historyActivity;

    //record
    @Column(name="previous_diseases", nullable = true)
    private String previousDiseases;

    @Column(name="smoke", nullable = true)
    private Boolean smoke;

    @Column(name="packages_cigarettes_pday", nullable = true)
    private Integer packagesCigarettesPday;

    @Column(name="drink", nullable = true)
    private Boolean drink;

    @Column(name="how_often_drink", nullable = true)
    private String howOftenDrink;

    @Column(name="hep_b_result", nullable = true)
    private Boolean hepBResult;

    @Column(name="hep_b_year", nullable = true)
    private String hepBYear;

    @Column(name="hep_c_result", nullable = true)
    private Boolean hepCResult;

    @Column(name="hep_c_year", nullable = true)
    private String hepCYear;

    @Column(name="vih_result", nullable = true)
    private Boolean vihResult;

    @Column(name="vih_year", nullable = true)
    private String vihYear;

    @Column(name="physiological", nullable = true)
    private String physiological;

    @Column(name="psychomotor_development", nullable = true)
    private String psychomotorDevelopment;

    @Column(name="diseases_of_childhood", nullable = true)
    private String diseasesOfChildhood;

    @Column(name="taking_medication", nullable = true)
    private String takingMedication;

    @Column(name="usual_medication", nullable = true, length = 4000)
    private String usualMedication;

    @Column(name="other_harmful_habits", nullable = true)
    private String otherHarmfulHabits;

    @Column(name="chronic_diseases", nullable = true)
    private Integer chronicDiseases;

    @Column(name="other_chronic_diseases", nullable = true)
    private String otherChronicDiseases;

    @Column(name="surgical_interventions", nullable = true, length = 4000)
    private String surgicalInterventions;

    @Column(name="hospitalizations", nullable = true, length = 4000)
    private String hospitalizations;

    @Column(name="accidents", nullable = true)
    private String accidents;

    @Column(name="blood_transfusions", nullable = true)
    private String bloodTransfusions;

    @Transient
    private Patient patient;

    @Transient
    private List<Attachment> attachmentList;

    @Transient
    @NotAudited
    private Directory directory;

    //Format for directories frontEnd
    @Transient
    @NotAudited
    private List<Map> files;

    public MedicalHistory() {
    }

    public String getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(String fileNumber) {
        this.fileNumber = fileNumber;
    }

    public Boolean getSmoke() {
        return smoke;
    }

    public void setSmoke(Boolean smoke) {
        this.smoke = smoke;
    }

    public Integer getPackagesCigarettesPday() {
        return packagesCigarettesPday;
    }

    public void setPackagesCigarettesPday(Integer packagesCigarettesPday) {
        this.packagesCigarettesPday = packagesCigarettesPday;
    }

    public Boolean getHepBResult() {
        return hepBResult;
    }

    public void setHepBResult(Boolean hepBResult) {
        this.hepBResult = hepBResult;
    }

    public String getHepBYear() {
        return hepBYear;
    }

    public void setHepBYear(String hepBYear) {
        this.hepBYear = hepBYear;
    }

    public Boolean getHepCResult() {
        return hepCResult;
    }

    public void setHepCResult(Boolean hepCResult) {
        this.hepCResult = hepCResult;
    }

    public String getHepCYear() {
        return hepCYear;
    }

    public void setHepCYear(String hepCYear) {
        this.hepCYear = hepCYear;
    }

    public Boolean getVihResult() {
        return vihResult;
    }

    public void setVihResult(Boolean vihResult) {
        this.vihResult = vihResult;
    }

    public String getVihYear() {
        return vihYear;
    }

    public void setVihYear(String vihYear) {
        this.vihYear = vihYear;
    }

    public String getPreviousDiseases() {
        return previousDiseases;
    }

    public void setPreviousDiseases(String previousDiseases) {
        this.previousDiseases = previousDiseases;
    }

    public String getHospitalizations() {
        return hospitalizations;
    }

    public void setHospitalizations(String hospitalizations) {
        this.hospitalizations = hospitalizations;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public Boolean getDrink() {
        return drink;
    }

    public void setDrink(Boolean drink) {
        this.drink = drink;
    }

    public String getHowOftenDrink() {
        return howOftenDrink;
    }

    public void setHowOftenDrink(String howOftenDrink) {
        this.howOftenDrink = howOftenDrink;
    }

    public Long getHistoryCode() {
        return historyCode;
    }

    public void setHistoryCode(Long historyCode) {
        this.historyCode = historyCode;
    }

    public String getOldHistoryCode() {
        return oldHistoryCode;
    }

    public void setOldHistoryCode(String oldHistoryCode) {
        this.oldHistoryCode = oldHistoryCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getHistoryActivity() {
        return historyActivity;
    }

    public void setHistoryActivity(Boolean historyActivity) {
        this.historyActivity = historyActivity;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public List<Map> getFiles() {
        return files;
    }

    public void setFiles(List<Map> files) {
        this.files = files;
    }

    public String getPhysiological() {
        return physiological;
    }

    public void setPhysiological(String physiological) {
        this.physiological = physiological;
    }

    public String getPsychomotorDevelopment() {
        return psychomotorDevelopment;
    }

    public void setPsychomotorDevelopment(String psychomotorDevelopment) {
        this.psychomotorDevelopment = psychomotorDevelopment;
    }

    public String getDiseasesOfChildhood() {
        return diseasesOfChildhood;
    }

    public void setDiseasesOfChildhood(String diseasesOfChildhood) {
        this.diseasesOfChildhood = diseasesOfChildhood;
    }

    public String getTakingMedication() {
        return takingMedication;
    }

    public void setTakingMedication(String takingMedication) {
        this.takingMedication = takingMedication;
    }

    public String getUsualMedication() {
        return usualMedication;
    }

    public void setUsualMedication(String usualMedication) {
        this.usualMedication = usualMedication;
    }

    public String getOtherHarmfulHabits() {
        return otherHarmfulHabits;
    }

    public void setOtherHarmfulHabits(String otherHarmfulHabits) {
        this.otherHarmfulHabits = otherHarmfulHabits;
    }

    public Integer getChronicDiseases() {
        return chronicDiseases;
    }

    public void setChronicDiseases(Integer chronicDiseases) {
        this.chronicDiseases = chronicDiseases;
    }

    public String getOtherChronicDiseases() {
        return otherChronicDiseases;
    }

    public void setOtherChronicDiseases(String otherChronicDiseases) {
        this.otherChronicDiseases = otherChronicDiseases;
    }

    public String getSurgicalInterventions() {
        return surgicalInterventions;
    }

    public void setSurgicalInterventions(String surgicalInterventions) {
        this.surgicalInterventions = surgicalInterventions;
    }

    public String getAccidents() {
        return accidents;
    }

    public void setAccidents(String accidents) {
        this.accidents = accidents;
    }

    public String getBloodTransfusions() {
        return bloodTransfusions;
    }

    public void setBloodTransfusions(String bloodTransfusions) {
        this.bloodTransfusions = bloodTransfusions;
    }
}