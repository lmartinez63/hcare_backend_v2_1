package com.landl.hcare.entity;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

@Entity
@Audited
@Table(name="med_app_medicament")
public class MedicalAppointmentMedicament extends AuditModel {
    @Id
    @GeneratedValue(generator = "med_app_medicament_generator")
    @SequenceGenerator(
            name = "med_app_medicament_generator",
            sequenceName = "med_app_medicament_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="medicament_id")
    @Audited
    private Medicament medicament;
    
    @Column(name="quantity")
    @Audited
    private Long quantity;
    
    @Column(name="administration_route_type")
    @Audited
    private Integer administrationRouteType;
    
    @Transient
    private String labelAdministrationRouteType;
    
    @Column(name="dosage_quantity")
    @Audited
    private Integer dosageQuantity;
    
    @Column(name="dosage_measuretype")
    @Audited
    private Integer dosageMeasuretype;
    
    @Transient
    private String labelDosageMeasuretype;
    
    @Column(name="dosage_frequency")
    @Audited
    private Integer dosageFrequency;
    
    @Column(name="treatment_time")
    @Audited
    private Integer treatmentTime;
    
    @Transient
    private String dosage;
    
    @Column(name="medical_indications", nullable = true, length = 4000)
    @Audited
    private String medicalIndications;
    
    @Column(name="medical_appointment_id")
    @Audited
    private Long medicalAppointmentId;
    
    @PostLoad
    private void postLoad() {
        this.dosage = this.dosageQuantity  + " "+ this.dosageMeasuretype + " cada " + this.dosageFrequency;
    }

	public MedicalAppointmentMedicament(Long id, Medicament medicament, Long quantity, Integer administrationRouteType,
			Integer dosageQuantity, Integer dosageMeasuretype, Integer dosageFrequency, String medicalIndications) {
		super();
		this.id = id;
		this.medicament = medicament;
		this.quantity = quantity;
		this.administrationRouteType = administrationRouteType;
		this.dosageQuantity = dosageQuantity;
		this.dosageMeasuretype = dosageMeasuretype;
		this.dosageFrequency = dosageFrequency;
		this.medicalIndications = medicalIndications;
	}

	public MedicalAppointmentMedicament() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Integer getAdministrationRouteType() {
		return administrationRouteType;
	}

	public void setAdministrationRouteType(Integer administrationRouteType) {
		this.administrationRouteType = administrationRouteType;
	}

	public Integer getDosageQuantity() {
		return dosageQuantity;
	}

	public void setDosageQuantity(Integer dosageQuantity) {
		this.dosageQuantity = dosageQuantity;
	}

	public Integer getDosageMeasuretype() {
		return dosageMeasuretype;
	}

	public void setDosageMeasuretype(Integer dosageMeasuretype) {
		this.dosageMeasuretype = dosageMeasuretype;
	}

	public Integer getDosageFrequency() {
		return dosageFrequency;
	}

	public void setDosageFrequency(Integer dosageFrequency) {
		this.dosageFrequency = dosageFrequency;
	}

	public String getMedicalIndications() {
		return medicalIndications;
	}

	public void setMedicalIndications(String medicalIndications) {
		this.medicalIndications = medicalIndications;
	}

	public Long getMedicalAppointmentId() {
		return medicalAppointmentId;
	}

	public void setMedicalAppointmentId(Long medicalAppointmentId) {
		this.medicalAppointmentId = medicalAppointmentId;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public Integer getTreatmentTime() {
		return treatmentTime;
	}

	public void setTreatmentTime(Integer treatmentTime) {
		this.treatmentTime = treatmentTime;
	}

	public String getLabelAdministrationRouteType() {
		return labelAdministrationRouteType;
	}

	public void setLabelAdministrationRouteType(String labelAdministrationRouteType) {
		this.labelAdministrationRouteType = labelAdministrationRouteType;
	}

	public String getLabelDosageMeasuretype() {
		return labelDosageMeasuretype;
	}

	public void setLabelDosageMeasuretype(String labelDosageMeasuretype) {
		this.labelDosageMeasuretype = labelDosageMeasuretype;
		this.dosage = this.dosageQuantity  + " "+ this.labelDosageMeasuretype + " cada " + this.dosageFrequency;
	}
}
