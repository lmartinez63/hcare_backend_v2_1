package com.landl.hcare.entity;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;

import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import javax.persistence.*;

@Entity
@Audited
@Table(name="label")
public class Label extends AuditModel {
    @Id
    @GeneratedValue(generator = "label_generator")
    @SequenceGenerator(
            name = "label_generator",
            sequenceName = "label_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="label_code")
    private String labelCode;

    @Column(name="module")
    private String module;

    @Column(name="sub_module")
    private String subModule;
    
    @Transient
    private String labelToString;

    @Column(name="label_value")
    private String labelValue;

    @Column(name="label_value_es_es")
    private String labelValueEsEs;

    @Column(name="validation_message")
    private String validationMessage;

    @Column(name="language")
    private String language;

    @PostLoad
    private void postLoad() {
        this.labelToString = UtilityTools.isNull(this.labelCode) + " - " + UtilityTools.isNull(this.module) + " - " + UtilityTools.isNull(this.subModule);
    }
    
    public Label() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelCode() {
        return labelCode;
    }

    public void setLabelCode(String labelCode) {
        this.labelCode = labelCode;
    }

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getSubModule() {
        return subModule;
    }

    public void setSubModule(String subModule) {
        this.subModule = subModule;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public String getLabelValueEsEs() {
        return labelValueEsEs;
    }

    public void setLabelValueEsEs(String labelValueEsEs) {
        this.labelValueEsEs = labelValueEsEs;
    }

	public String getLabelToString() {
		return labelToString;
	}

	public void setLabelToString(String labelToString) {
		this.labelToString = labelToString;
	}

    

}
