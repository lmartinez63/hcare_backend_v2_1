package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.List;

@Entity
@Audited
@Table(name="field_definition")
public class FieldDefinition extends AuditModel {
    @Id
    @GeneratedValue(generator = "field_def_generator")
    @SequenceGenerator(
            name = "field_def_generator",
            sequenceName = "field_def_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="field_definition_code")
    private String fieldDefinitionCode;

    //Map one to one association between Person and Address
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="label_id")
    private Label label;

    @Transient
    @NotAudited
    private String labelValue;

    //$date{{medicalAppointment.dateEntered}}
    @Column(name="definition")
    private String definition;

    @Transient
    @NotAudited
    private Object objectValue;

    @Column(name="field_type")
    private Integer fieldType;

    @Column(name="visible_rule_exp")
    private String visibleRuleExp;

    @Column(name="custom_features",length = 4000, nullable = true)
    private String customFeatures;

    @Column(name="edit_rule_exp")
    private String editRuleExp;

    @Column(name="select_source",length = 4000, nullable = true)
    private String selectSource;

    @Column(name="on_click_event",length = 4000, nullable = true)
    private String onClickEvent;

    @Column(name="on_change_event",length = 4000, nullable = true)
    private String onChangeEvent;

    @Column(name="prepend_button",length = 4000, nullable = true)
    private String prependButton;

    @Column(name="outter_button",length = 4000, nullable = true)
    private String outterButton;

    @Column(name="mask")
    private String mask;

    @Column(name="preffix")
    private String preffix;

    @Column(name="suffix")
    private String suffix;

    @Column(name="xs_size")
    private Integer xsSize;

    @Column(name="order_number")
    private Integer orderNumber;

    @Column(name="field_size")
    private Integer fieldSize;

    @Transient
    @NotAudited
    private Boolean visible;

    @Transient
    @NotAudited
    private Boolean editable;

    @Transient
    @NotAudited
    private Boolean modal;

    @Transient
    @NotAudited
    private List<Validation> validationList;

    @Transient
    @NotAudited
    private Boolean required;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldDefinitionCode() {
        return fieldDefinitionCode;
    }

    public void setFieldDefinitionCode(String fieldDefinitionCode) {
        this.fieldDefinitionCode = fieldDefinitionCode;
    }

    public String getVisibleRuleExp() {
        return visibleRuleExp;
    }

    public void setVisibleRuleExp(String visibleRuleExp) {
        this.visibleRuleExp = visibleRuleExp;
    }

    public String getEditRuleExp() {
        return editRuleExp;
    }

    public void setEditRuleExp(String editRuleExp) {
        this.editRuleExp = editRuleExp;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Object getObjectValue() {
        return objectValue;
    }

    public void setObjectValue(Object objectValue) {
        this.objectValue = objectValue;
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }


    public List<Validation> getValidationList() {
        return validationList;
    }

    public void setValidationList(List<Validation> validationList) {
        this.validationList = validationList;
    }

    public String getSelectSource() {
        return selectSource;
    }

    public void setSelectSource(String selectSource) {
        this.selectSource = selectSource;
    }

    public Boolean getModal() {
        return modal;
    }

    public void setModal(Boolean modal) {
        this.modal = modal;
    }

    public String getOnClickEvent() {
        return onClickEvent;
    }

    public void setOnClickEvent(String onClickEvent) {
        this.onClickEvent = onClickEvent;
    }

    public String getOnChangeEvent() {
        return onChangeEvent;
    }

    public void setOnChangeEvent(String onChangeEvent) {
        this.onChangeEvent = onChangeEvent;
    }

    public String getOutterButton() {
        return outterButton;
    }

    public void setOutterButton(String outterButton) {
        this.outterButton = outterButton;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(Integer fieldSize) {
        this.fieldSize = fieldSize;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getPreffix() {
        return preffix;
    }

    public void setPreffix(String preffix) {
        this.preffix = preffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getXsSize() {
        return xsSize;
    }

    public void setXsSize(Integer xsSize) {
        this.xsSize = xsSize;
    }

    public Boolean getRequired() {
        return required;
    }

    public void setRequired(Boolean required) {
        this.required = required;
    }

    public String getPrependButton() {
        return prependButton;
    }

    public void setPrependButton(String prependButton) {
        this.prependButton = prependButton;
    }

    public String getCustomFeatures() {
        return customFeatures;
    }

    public void setCustomFeatures(String customFeatures) {
        this.customFeatures = customFeatures;
    }
}