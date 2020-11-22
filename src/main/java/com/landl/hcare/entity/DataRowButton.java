package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
//TODO Change to extends to frontEndButton class on extends
@Entity
@Audited
@Table(name="data_row_button")
public class DataRowButton extends AuditModel {
    @Id
    @GeneratedValue(generator = "data_row_button_generator")
    @SequenceGenerator(
            name = "data_row_button_generator",
            sequenceName = "data_row_button_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="data_row_button_code")
    private String dataRowButtonCode;

    @Column(name="visibility_condition")
    private String visibilityCondition;

    @Transient
    @NotAudited
    private String labelValue;

    @Column(name="data_row_button_event")
    private String dataRowButtonEvent;

    @Column(name="icon")
    private String icon;

    //Map one to one association between Person and Address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="label_id")
    private Label label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataRowButtonCode() {
        return dataRowButtonCode;
    }

    public void setDataRowButtonCode(String dataRowButtonCode) {
        this.dataRowButtonCode = dataRowButtonCode;
    }

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }

    public String getDataRowButtonEvent() {
        return dataRowButtonEvent;
    }

    public void setDataRowButtonEvent(String dataRowButtonEvent) {
        this.dataRowButtonEvent = dataRowButtonEvent;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String getVisibilityCondition() {
        return visibilityCondition;
    }

    public void setVisibilityCondition(String visibilityCondition) {
        this.visibilityCondition = visibilityCondition;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
