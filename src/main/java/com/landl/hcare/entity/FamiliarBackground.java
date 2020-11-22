package com.landl.hcare.entity;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

@Entity
@Audited
@Table(name="familiar_background")
public class FamiliarBackground extends AuditModel {
	@Id
    @GeneratedValue(generator = "familiar_background_generator")
    @SequenceGenerator(
            name = "familiar_background_generator",
            sequenceName = "familiar_background_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    private Long id;

    @Column(name="familiar_type")
    @Audited
    private Integer familiarType;
    
    @Transient
    private String labelFamiliarType;
    
    @Column(name="medical_appointment_id")
    @Audited
    private Long medicalAppointmentId;

    //Should be stored in label
    @Column(name="background_summary", nullable = true,length = 4000)
    @Audited
    private String backgroundSummary;

    public FamiliarBackground() {
    }

	public FamiliarBackground(Long id, Integer familiarType, String backgroundSummary) {
		super();
		this.id = id;
		this.familiarType = familiarType;
		this.backgroundSummary = backgroundSummary;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFamiliarType() {
		return familiarType;
	}

	public void setFamiliarType(Integer familiarType) {
		this.familiarType = familiarType;
	}

	

	public String getBackgroundSummary() {
		return backgroundSummary;
	}

	public void setBackgroundSummary(String backgroundSummary) {
		this.backgroundSummary = backgroundSummary;
	}

	public Long getMedicalAppointmentId() {
		return medicalAppointmentId;
	}

	public void setMedicalAppointmentId(Long medicalAppointmentId) {
		this.medicalAppointmentId = medicalAppointmentId;
	}

	public String getLabelFamiliarType() {
		return labelFamiliarType;
	}

	public void setLabelFamiliarType(String labelFamiliarType) {
		this.labelFamiliarType = labelFamiliarType;
	}
    
    

}
