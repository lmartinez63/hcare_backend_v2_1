package com.landl.hcare.entity;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

@Entity
@Audited
@Table(name="property")
public class Property extends AuditModel {
    @Id
    @GeneratedValue(generator = "property_generator")
    @SequenceGenerator(
            name = "property_generator",
            sequenceName = "property_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="module")
    private String module;

    @Column(name="property_code")
    private String propertyCode;

    @Column(name="property_value")
    private String propertyValue;

    @Transient
    @NotAudited
    private String labelValue;

    //Map one to one association between Person and Address
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="label_id")
    private Label label;

    public Property() {
    }

    public Property(String module, String propertyCode, String propertyValue, String labelValue) {
        this.module = module;
        this.propertyCode = propertyCode;
        this.propertyValue = propertyValue;
        this.labelValue = labelValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

}
