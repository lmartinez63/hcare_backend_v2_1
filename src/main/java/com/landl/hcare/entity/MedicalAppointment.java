package com.landl.hcare.entity;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Audited
@Table(name="medical_appointment")
public class MedicalAppointment  extends AuditModel {
    @Id
    @GeneratedValue(generator = "med_app_generator")
    @SequenceGenerator(
            name = "med_app_generator",
            sequenceName = "med_app_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    private Long id;

    @Column(name="date_appointment")
    private Date dateAppointment;

    @Column(name="date_attention")
    private Date dateAttention;

    @Transient
    @NotAudited
    private String dateAppointmentDateFormatted;

    @Transient
    @NotAudited
    private String dateAppointmentTimeFormatted;

    @Column(name="status")
    private Integer status;

    @Transient
    private String labelStatus;

    @Column(name="medical_area_id")
    private Long medicalAreaId;

    @Column(name="doctor_id")
    private Long doctorId;

    @Column(name="notes",length = 4000, nullable = true)
    private String notes;


    @Column(name="medical_appointment_type")
    private Integer medicalAppointmentType;

    @Column(name="parent_medical_appointment_id")
    private Long parentMedicalAppointmentId;

    //Anamnesis
    @Column(name="main_symptoms", nullable = true,length = 4000)
    private String mainSymptoms;
    
    @Column(name="main_symptoms_time_quantity")
    private Integer mainSymptomsTimeQuantity;

    @Column(name="main_symptoms_time_type")
    private Integer mainSymptomsTimeType;

    @Column(name="allergies", nullable = true,length = 4000)
    private String allergies;

    @Transient
    private Integer[] allergiesArray;

    @Column(name="pathological_background", nullable = true,length = 4000)
    private String pathologicalBackground;
    
    @Transient
    private Integer[] pathologicalBackgroundArray;

    @Column(name="other_pathological_background", nullable = true,length = 4000)
    private String otherPathologicalBackground;

    @Column(name="visit_reason", nullable = true,length = 4000)
    private String visitReason;

    @Column(name="sickness_time_quantity")
    private Integer sicknessTimeQuantity;

    @Column(name="sickness_time_type")
    private Integer sicknessTimeType;

    @Column(name="chronological_story", nullable = true,length = 4000)
    private String chronologicalStory;

    @Column(name="biological_functions", nullable = true,length = 4000)
    private String biologicalFunctions;

    @Column(name="background", nullable = true,length = 4000)
    private String background;
    
    @Column(name="current_illness", nullable = true,length = 4000)
    private String currentIllness;
    
    @Column(name="preferential_physical_exam", nullable = true,length = 4000)
    private String preferentialPhysicalExam;

    //Examen Clinico
    @Column(name="general_clinic_exam", nullable = true,length = 4000)
    private String generalClinicExam;

    @Column(name="fc", nullable = true,length = 4000)
    private String fc;

    @Column(name="fr", nullable = true,length = 4000)
    private String fr;

    @Column(name="t", nullable = true,length = 4000)
    private String t;

    @Column(name="pa", nullable = true,length = 4000)
    private String pa;

    @Column(name="weight", nullable = true)
    private Integer weight;

    @Column(name="height", nullable = true)
    private Integer height;

    @Column(name="general_status", nullable = true,length = 4000)
    private String generalStatus;

    @Column(name="hydration_status", nullable = true,length = 4000)
    private String hydrationStatus;

    @Column(name="nutrition_status", nullable = true,length = 4000)
    private String nutritionStatus;

    @Column(name="consciousness_state", nullable = true,length = 4000)
    private String consciousnessState;

    @Column(name="imc", nullable = true,length = 4000)
    private String imc;

    @Column(name="tcsc", nullable = true,length = 4000)
    private String tcsc;

    @Column(name="head", nullable = true,length = 4000)
    private String head;

    @Column(name="mouth", nullable = true,length = 4000)
    private String mouth;

    @Column(name="neck", nullable = true,length = 4000)
    private String neck;

    @Column(name="thorax", nullable = true,length = 4000)
    private String thorax;

    @Column(name="heart", nullable = true,length = 4000)
    private String heart;

    @Column(name="lungs", nullable = true,length = 4000)
    private String lungs;

    @Column(name="abdomen", nullable = true,length = 4000)
    private String abdomen;

    @Column(name="urinary_genito", nullable = true,length = 4000)
    private String urinaryGenito;

    @Column(name="extremities", nullable = true,length = 4000)
    private String extremities;

    @Column(name="peripheral_pulses", nullable = true,length = 4000)
    private String peripheralPulses;

    @Column(name="neurological", nullable = true,length = 4000)
    private String neurological;

    @Column(name="regional_clinic_exam", nullable = true, length = 4000)
    private String regionalClinicExam;

    //Diagnostic
    @Column(name="presumptive_coherent", nullable = true, length = 4000)
    private String presumptiveCoherent;

    @Column(name="definitive_coherent", nullable = true, length = 4000)
    private String definitiveCoherent;
    
    @Transient
    private Integer[] definitiveCoherentArray;

    @Column(name="preferential_diagnostic", nullable = true)
    private Integer preferentialDiagnostic;

    //WorkPlan
    //@Column(name="presumptive_coherent", nullable = true,length = 4000)
    //private String presumptiveCoherent;

    //Map one to one association between Person and Address
    @OneToOne(cascade = CascadeType.MERGE)
    private Patient patient;
    
    @Transient
    @NotAudited
    private List<Attachment> attachmentList;
    
    @OneToMany
    @NotAudited
    @JoinColumn(name = "medical_appointment_id")
    private List<MedicalAppointmentMedicament> medicalAppointmentMedicamentList;
    
    @OneToMany
    @NotAudited
    @JoinColumn(name = "medical_appointment_id")
    private List<FamiliarBackground> familiarBackgroundList;
    
    @ManyToMany
    @NotAudited
    @JoinTable(name = "MEDICALAPPOINTMENT_AUXILIAREXAMS", joinColumns = {
            @JoinColumn(name = "MEDICALAPPOINTMENT_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "AUXILIAREXAM_ID") })
    private Set<AuxiliarExam> auxiliarExamList = new HashSet<>();
    

    //Format for directories frontEnd
    @Transient
    @NotAudited
    private List<Map> files;
    
    @PostLoad
    private void postLoad() {
    	/*if(this.auxiliarExams.size() > 0) {
    			this.auxiliarExamList = auxiliarExams.stream().collect(Collectors.toList());	
    	}*/
    }
    
    
    public MedicalAppointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getMedicalAreaId() {
        return medicalAreaId;
    }

    public void setMedicalAreaId(Long medicalAreaId) {
        this.medicalAreaId = medicalAreaId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getVisitReason() {
        return visitReason;
    }

    public void setVisitReason(String visitReason) {
        this.visitReason = visitReason;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getGeneralClinicExam() {
        return generalClinicExam;
    }

    public void setGeneralClinicExam(String generalClinicExam) {
        this.generalClinicExam = generalClinicExam;
    }
    
    public Integer getMainSymptomsTimeQuantity() {
		return mainSymptomsTimeQuantity;
	}

	public void setMainSymptomsTimeQuantity(Integer mainSymptomsTimeQuantity) {
		this.mainSymptomsTimeQuantity = mainSymptomsTimeQuantity;
	}

	public Integer getMainSymptomsTimeType() {
		return mainSymptomsTimeType;
	}

	public void setMainSymptomsTimeType(Integer mainSymptomsTimeType) {
		this.mainSymptomsTimeType = mainSymptomsTimeType;
	}

	public String getFc() {
		return fc;
	}

	public void setFc(String fc) {
		this.fc = fc;
	}

	public String getFr() {
		return fr;
	}

	public void setFr(String fr) {
		this.fr = fr;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getGeneralStatus() {
        return generalStatus;
    }

    public void setGeneralStatus(String generalStatus) {
        this.generalStatus = generalStatus;
    }

    public String getHydrationStatus() {
        return hydrationStatus;
    }

    public void setHydrationStatus(String hydrationStatus) {
        this.hydrationStatus = hydrationStatus;
    }

    public String getNutritionStatus() {
        return nutritionStatus;
    }

    public void setNutritionStatus(String nutritionStatus) {
        this.nutritionStatus = nutritionStatus;
    }

    public String getConsciousnessState() {
        return consciousnessState;
    }

    public void setConsciousnessState(String consciousnessState) {
        this.consciousnessState = consciousnessState;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }

    public String getTcsc() {
        return tcsc;
    }

    public void setTcsc(String tcsc) {
        this.tcsc = tcsc;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getThorax() {
        return thorax;
    }

    public void setThorax(String thorax) {
        this.thorax = thorax;
    }

    public String getHeart() {
        return heart;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public String getLungs() {
        return lungs;
    }

    public void setLungs(String lungs) {
        this.lungs = lungs;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getUrinaryGenito() {
        return urinaryGenito;
    }

    public void setUrinaryGenito(String urinaryGenito) {
        this.urinaryGenito = urinaryGenito;
    }

    public String getExtremities() {
        return extremities;
    }

    public void setExtremities(String extremities) {
        this.extremities = extremities;
    }

    public String getPeripheralPulses() {
        return peripheralPulses;
    }

    public void setPeripheralPulses(String peripheralPulses) {
        this.peripheralPulses = peripheralPulses;
    }

    public String getNeurological() {
        return neurological;
    }

    public void setNeurological(String neurological) {
        this.neurological = neurological;
    }

    public String getRegionalClinicExam() {
        return regionalClinicExam;
    }

    public void setRegionalClinicExam(String regionalClinicExam) {
        this.regionalClinicExam = regionalClinicExam;
    }

    public String getPresumptiveCoherent() {
        return presumptiveCoherent;
    }

    public void setPresumptiveCoherent(String presumptiveCoherent) {
        this.presumptiveCoherent = presumptiveCoherent;
    }

    public String getDefinitiveCoherent() {
        return definitiveCoherent;
    }

    public void setDefinitiveCoherent(String definitiveCoherent) {
        this.definitiveCoherent = definitiveCoherent;
    }

    public Integer getMedicalAppointmentType() {
        return medicalAppointmentType;
    }

    public void setMedicalAppointmentType(Integer medicalAppointmentType) {
        this.medicalAppointmentType = medicalAppointmentType;
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

    public String getDateAppointmentDateFormatted() {
        if (dateAppointment != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.format(dateAppointment);
        }
        return null;
    }

    public String getDateAppointmentTimeFormatted() {
        if (dateAppointment != null) {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm a");
            return format.format(dateAppointment);
        }
        return null;
    }

    public Integer getPreferentialDiagnostic() {
        return preferentialDiagnostic;
    }

    public void setPreferentialDiagnostic(Integer preferentialDiagnostic) {
        this.preferentialDiagnostic = preferentialDiagnostic;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Map> getFiles() {
        return files;
    }

    public void setFiles(List<Map> files) {
        this.files = files;
    }

    public String getMainSymptoms() {
        return mainSymptoms;
    }

    public void setMainSymptoms(String mainSymptoms) {
        this.mainSymptoms = mainSymptoms;
    }

    public String getPathologicalBackground() {
        return pathologicalBackground;
    }

    public void setPathologicalBackground(String pathologicalBackground) {
        this.pathologicalBackground = pathologicalBackground;
    }

    public String getOtherPathologicalBackground() {
        return otherPathologicalBackground;
    }

    public void setOtherPathologicalBackground(String otherPathologicalBackground) {
        this.otherPathologicalBackground = otherPathologicalBackground;
    }

    public Integer getSicknessTimeQuantity() {
        return sicknessTimeQuantity;
    }

    public void setSicknessTimeQuantity(Integer sicknessTimeQuantity) {
        this.sicknessTimeQuantity = sicknessTimeQuantity;
    }

    public Integer getSicknessTimeType() {
        return sicknessTimeType;
    }

    public void setSicknessTimeType(Integer sicknessTimeType) {
        this.sicknessTimeType = sicknessTimeType;
    }

    public String getChronologicalStory() {
        return chronologicalStory;
    }

    public void setChronologicalStory(String chronologicalStory) {
        this.chronologicalStory = chronologicalStory;
    }

    public String getBiologicalFunctions() {
        return biologicalFunctions;
    }

    public void setBiologicalFunctions(String biologicalFunctions) {
        this.biologicalFunctions = biologicalFunctions;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Integer[] getAllergiesArray() {
        return allergiesArray;
    }

    public void setAllergiesArray(Integer[] allergiesArray) {
        this.allergiesArray = allergiesArray;
    }

    public String getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(String labelStatus) {
        this.labelStatus = labelStatus;
    }

    public Date getDateAttention() {
        return dateAttention;
    }

    public void setDateAttention(Date dateAttention) {
        this.dateAttention = dateAttention;
    }

    public Long getParentMedicalAppointmentId() {
        return parentMedicalAppointmentId;
    }

    public void setParentMedicalAppointmentId(Long parentMedicalAppointmentId) {
        this.parentMedicalAppointmentId = parentMedicalAppointmentId;
    }

	public Integer[] getPathologicalBackgroundArray() {
		return pathologicalBackgroundArray;
	}

	public void setPathologicalBackgroundArray(Integer[] pathologicalBackgroundArray) {
		this.pathologicalBackgroundArray = pathologicalBackgroundArray;
	}

	public Integer[] getDefinitiveCoherentArray() {
		return definitiveCoherentArray;
	}

	public void setDefinitiveCoherentArray(Integer[] definitiveCoherentArray) {
		this.definitiveCoherentArray = definitiveCoherentArray;
	}

	public List<FamiliarBackground> getFamiliarBackgroundList() {
		return familiarBackgroundList;
	}

	public void setFamiliarBackgroundList(List<FamiliarBackground> familiarBackgroundList) {
		this.familiarBackgroundList = familiarBackgroundList;
	}

	public String getCurrentIllness() {
		return currentIllness;
	}

	public void setCurrentIllness(String currentIllness) {
		this.currentIllness = currentIllness;
	}

	public String getPreferentialPhysicalExam() {
		return preferentialPhysicalExam;
	}

	public void setPreferentialPhysicalExam(String preferentialPhysicalExam) {
		this.preferentialPhysicalExam = preferentialPhysicalExam;
	}


	public Set<AuxiliarExam> getAuxiliarExamList() {
		return auxiliarExamList;
	}


	public void setAuxiliarExamList(Set<AuxiliarExam> auxiliarExamList) {
		this.auxiliarExamList = auxiliarExamList;
	}


	public List<MedicalAppointmentMedicament> getMedicalAppointmentMedicamentList() {
		return medicalAppointmentMedicamentList;
	}


	public void setMedicalAppointmentMedicamentList(List<MedicalAppointmentMedicament> medicalAppointmentMedicamentList) {
		this.medicalAppointmentMedicamentList = medicalAppointmentMedicamentList;
	}
	
	

}
