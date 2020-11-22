package com.landl.hcare.entity;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

@Entity
@Audited
@Table(name = "medicament")
public class Medicament extends AuditModel {
	@Id
	@GeneratedValue(generator = "medicament_generator")
	@SequenceGenerator(name = "medicament_generator", sequenceName = "medicament_sequence", initialValue = 1000, allocationSize = 1)
	private Long id;

	@Column(name = "code")
	private String code;

	@Column(name = "common_denomination")
	private String commonDenomination;

	@Column(name = "concentration")
	private String concentration;

	@Column(name = "pharmaceutical_form")
	private String pharmaceuticalForm;

	@Column(name = "presentation")
	private String presentation;

	@Column(name = "source")
	private String source;
	
	@Transient
	private String medicamentToString;
	
	@PostLoad
    private void postLoad() {
        this.medicamentToString = UtilityTools.isNull(this.commonDenomination) + " - " + UtilityTools.isNull(this.concentration) + " - " + UtilityTools.isNull(this.pharmaceuticalForm);
    }

	public Medicament() {
	}
	
	

	public Medicament(Long id, String code, String commonDenomination, String concentration, String pharmaceuticalForm,
			String presentation, String source) {
		super();
		this.id = id;
		this.code = code;
		this.commonDenomination = commonDenomination;
		this.concentration = concentration;
		this.pharmaceuticalForm = pharmaceuticalForm;
		this.presentation = presentation;
		this.source = source;
	}



	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCommonDenomination() {
		return commonDenomination;
	}

	public void setCommonDenomination(String commonDenomination) {
		this.commonDenomination = commonDenomination;
	}

	public String getConcentration() {
		return concentration;
	}

	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}

	public String getPharmaceuticalForm() {
		return pharmaceuticalForm;
	}

	public void setPharmaceuticalForm(String pharmaceuticalForm) {
		this.pharmaceuticalForm = pharmaceuticalForm;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getMedicamentToString() {
		return medicamentToString;
	}

	public void setMedicamentToString(String medicamentToString) {
		this.medicamentToString = medicamentToString;
	}
	
	

}
