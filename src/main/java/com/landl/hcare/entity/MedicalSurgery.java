package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Audited
@Table(name="medical_surgery")
public class MedicalSurgery extends AuditModel {
    @Id
    @GeneratedValue(generator = "medical_surgery_generator")
    @SequenceGenerator(
            name = "medical_surgery_generator",
            sequenceName = "medical_surgery_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="surgery_type_id")
    private SurgeryType surgeryType;

    @Column(name="status")
    @Audited
    private Integer status;

    @Column(name="bedCode")
    @Audited
    private String bedCode;

    @Column(name="required_datetime")
    @Audited
    private Date requiredDatetime;

    @Column(name="surgery_start_datetime")
    @Audited
    private Date surgeryStartDatetime;

    @Column(name="surgery_end_datetime")
    @Audited
    private Date surgeryEndDatetime;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="surgery_area_id")
    private SurgeryArea surgeryArea;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="surgery_anesthesia_id")
    private SurgeryAnesthesia surgeryAnesthesia;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="informed_consent_id")
    private Attachment informedConsentReport;

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="surgery_report_id")
    private Attachment surgeryReport;

    @OneToMany
    @JoinColumn(name = "medical_surgery_id")
    private List<SurgeryDoctor> surgeryDoctors;

    @OneToMany
    @JoinColumn(name = "medical_surgery_id")
    private List<SurgeryNurse> surgeryNurses;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="medical_appointment_id")
    private MedicalAppointment medicalAppointment;

    @OneToMany
    @JoinColumn(name = "medical_surgery_id")
    private List<EvolutionLog> evolutionLogList;

    @OneToMany
    @JoinColumn(name = "medical_surgery_id")
    private List<MedicalAnalysis> medicalAnalysisList;

    @Transient
    private Patient patient;

    @Transient
    private String labelStatus;

    @Transient
    private String requiredDate;

    @Transient
    private Long surgeryAreaId;

    @Transient
    private String mainDoctorFullName;

    // Verification List

    @Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="verification_list_id")
    private Attachment verificationListReport;


    @Column(name="entrance_1")
    @Audited
    private Boolean entrance1;

    @Column(name="entrance_2")
    @Audited
    private Boolean entrance2;

    @Column(name="entrance_3")
    @Audited
    private Boolean entrance3;

    @Column(name="entrance_4")
    @Audited
    private Boolean entrance4;

    @Column(name="entrance_5")
    @Audited
    private Boolean entrance5;

    @Column(name="entrance_6")
    @Audited
    private Boolean entrance6;

    @Column(name="entrance_7")
    @Audited
    private Boolean entrance7;

    @Column(name="entrance_8")
    @Audited
    private Boolean entrance8;

    @Column(name="entrance_9")
    @Audited
    private Boolean entrance9;

    @Column(name="pause_1")
    @Audited
    private Boolean pause1;

    @Column(name="pause_2")
    @Audited
    private Boolean pause2;

    @Column(name="pause_3")
    @Audited
    private Boolean pause3;

    @Column(name="pause_4")
    @Audited
    private Boolean pause4;

    @Column(name="pause_5")
    @Audited
    private Boolean pause5;

    @Column(name="pause_6")
    @Audited
    private Boolean pause6;

    @Column(name="pause_7")
    @Audited
    private Boolean pause7;

    @Column(name="pause_8")
    @Audited
    private Boolean pause8;

    @Column(name="pause_9")
    @Audited
    private Boolean pause9;

    @Column(name="pause_10")
    @Audited
    private Boolean pause10;

    @Column(name="exit_1")
    @Audited
    private Boolean exit1;

    @Column(name="exit_2")
    @Audited
    private Boolean exit2;

    @Column(name="exit_3")
    @Audited
    private Boolean exit3;

    @Column(name="exit_4")
    @Audited
    private Boolean exit4;
    //Format for directories frontEnd
    @Transient
    @NotAudited
    private List<Map> files;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SurgeryType getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(SurgeryType surgeryType) {
        this.surgeryType = surgeryType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRequiredDatetime() {
        return requiredDatetime;
    }

    public void setRequiredDatetime(Date requiredDatetime) {
        this.requiredDatetime = requiredDatetime;
    }

    public Date getSurgeryStartDatetime() {
        return surgeryStartDatetime;
    }

    public void setSurgeryStartDatetime(Date surgeryStartDatetime) {
        this.surgeryStartDatetime = surgeryStartDatetime;
    }

    public Date getSurgeryEndDatetime() {
        return surgeryEndDatetime;
    }

    public void setSurgeryEndDatetime(Date surgeryEndDatetime) {
        this.surgeryEndDatetime = surgeryEndDatetime;
    }

    public SurgeryArea getSurgeryArea() {
        return surgeryArea;
    }

    public void setSurgeryArea(SurgeryArea surgeryArea) {
        this.surgeryArea = surgeryArea;
    }

    public List<SurgeryDoctor> getSurgeryDoctors() {
        return surgeryDoctors;
    }

    public void setSurgeryDoctors(List<SurgeryDoctor> surgeryDoctors) {
        this.surgeryDoctors = surgeryDoctors;
    }

    public List<SurgeryNurse> getSurgeryNurses() {
        return surgeryNurses;
    }

    public void setSurgeryNurses(List<SurgeryNurse> surgeryNurses) {
        this.surgeryNurses = surgeryNurses;
    }

    public MedicalAppointment getMedicalAppointment() {
        return medicalAppointment;
    }

    public void setMedicalAppointment(MedicalAppointment medicalAppointment) {
        this.medicalAppointment = medicalAppointment;
    }

    public List<MedicalAnalysis> getMedicalAnalysisList() {
        return medicalAnalysisList;
    }

    public void setMedicalAnalysisList(List<MedicalAnalysis> medicalAnalysisList) {
        this.medicalAnalysisList = medicalAnalysisList;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Map> getFiles() {
        return files;
    }

    public void setFiles(List<Map> files) {
        this.files = files;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Long getSurgeryAreaId() {
        return surgeryAreaId;
    }

    public void setSurgeryAreaId(Long surgeryAreaId) {
        this.surgeryAreaId = surgeryAreaId;
    }

    public String getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(String labelStatus) {
        this.labelStatus = labelStatus;
    }

    public SurgeryAnesthesia getSurgeryAnesthesia() {
        return surgeryAnesthesia;
    }

    public void setSurgeryAnesthesia(SurgeryAnesthesia surgeryAnesthesia) {
        this.surgeryAnesthesia = surgeryAnesthesia;
    }

    public String getBedCode() {
        return bedCode;
    }

    public void setBedCode(String bedCode) {
        this.bedCode = bedCode;
    }

    public Boolean getEntrance1() {
        return entrance1;
    }

    public void setEntrance1(Boolean entrance1) {
        this.entrance1 = entrance1;
    }

    public Boolean getEntrance2() {
        return entrance2;
    }

    public void setEntrance2(Boolean entrance2) {
        this.entrance2 = entrance2;
    }

    public Boolean getEntrance3() {
        return entrance3;
    }

    public void setEntrance3(Boolean entrance3) {
        this.entrance3 = entrance3;
    }

    public Boolean getEntrance4() {
        return entrance4;
    }

    public void setEntrance4(Boolean entrance4) {
        this.entrance4 = entrance4;
    }

    public Boolean getEntrance5() {
        return entrance5;
    }

    public void setEntrance5(Boolean entrance5) {
        this.entrance5 = entrance5;
    }

    public Boolean getEntrance6() {
        return entrance6;
    }

    public void setEntrance6(Boolean entrance6) {
        this.entrance6 = entrance6;
    }

    public Boolean getEntrance7() {
        return entrance7;
    }

    public void setEntrance7(Boolean entrance7) {
        this.entrance7 = entrance7;
    }

    public Boolean getEntrance8() {
        return entrance8;
    }

    public void setEntrance8(Boolean entrance8) {
        this.entrance8 = entrance8;
    }

    public Boolean getEntrance9() {
        return entrance9;
    }

    public void setEntrance9(Boolean entrance9) {
        this.entrance9 = entrance9;
    }

    public Boolean getPause1() {
        return pause1;
    }

    public void setPause1(Boolean pause1) {
        this.pause1 = pause1;
    }

    public Boolean getPause2() {
        return pause2;
    }

    public void setPause2(Boolean pause2) {
        this.pause2 = pause2;
    }

    public Boolean getPause3() {
        return pause3;
    }

    public void setPause3(Boolean pause3) {
        this.pause3 = pause3;
    }

    public Boolean getPause4() {
        return pause4;
    }

    public void setPause4(Boolean pause4) {
        this.pause4 = pause4;
    }

    public Boolean getPause5() {
        return pause5;
    }

    public void setPause5(Boolean pause5) {
        this.pause5 = pause5;
    }

    public Boolean getPause6() {
        return pause6;
    }

    public void setPause6(Boolean pause6) {
        this.pause6 = pause6;
    }

    public Boolean getPause7() {
        return pause7;
    }

    public void setPause7(Boolean pause7) {
        this.pause7 = pause7;
    }

    public Boolean getPause8() {
        return pause8;
    }

    public void setPause8(Boolean pause8) {
        this.pause8 = pause8;
    }

    public Boolean getPause9() {
        return pause9;
    }

    public void setPause9(Boolean pause9) {
        this.pause9 = pause9;
    }

    public Boolean getPause10() {
        return pause10;
    }

    public void setPause10(Boolean pause10) {
        this.pause10 = pause10;
    }

    public Boolean getExit1() {
        return exit1;
    }

    public void setExit1(Boolean exit1) {
        this.exit1 = exit1;
    }

    public Boolean getExit2() {
        return exit2;
    }

    public void setExit2(Boolean exit2) {
        this.exit2 = exit2;
    }

    public Boolean getExit3() {
        return exit3;
    }

    public void setExit3(Boolean exit3) {
        this.exit3 = exit3;
    }

    public Boolean getExit4() {
        return exit4;
    }

    public void setExit4(Boolean exit4) {
        this.exit4 = exit4;
    }

    public Attachment getInformedConsentReport() {
        return informedConsentReport;
    }

    public void setInformedConsentReport(Attachment informedConsentReport) {
        this.informedConsentReport = informedConsentReport;
    }

    public List<EvolutionLog> getEvolutionLogList() {
        return evolutionLogList;
    }

    public void setEvolutionLogList(List<EvolutionLog> evolutionLogList) {
        this.evolutionLogList = evolutionLogList;
    }

    public Attachment getVerificationListReport() {
        return verificationListReport;
    }

    public void setVerificationListReport(Attachment verificationListReport) {
        this.verificationListReport = verificationListReport;
    }

    public Attachment getSurgeryReport() {
        return surgeryReport;
    }

    public void setSurgeryReport(Attachment surgeryReport) {
        this.surgeryReport = surgeryReport;
    }

    public String getMainDoctorFullName() {
        return mainDoctorFullName;
    }

    public void setMainDoctorFullName(String mainDoctorFullName) {
        this.mainDoctorFullName = mainDoctorFullName;
    }
}
