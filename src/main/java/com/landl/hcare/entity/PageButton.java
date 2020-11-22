package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

@Entity
@Audited
@Table(name="page_button")
public class PageButton extends AuditModel {
    @Id
    @GeneratedValue(generator = "page_button_generator")
    @SequenceGenerator(
            name = "page_button_generator",
            sequenceName = "page_button_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="visible_rule_exp")
    private String visibleRuleExp;

    @Column(name="eventDefinition",length = 4000, nullable = true)
    private String eventDefinition;

    @Column(name="button_code")
    private String buttonCode;

    @Column(name="button_type")
    private Integer buttonType;

    @Column(name="display_order")
    private Integer displayOrder;

    @Column(name="icon")
    private String icon;

    @Column(name="page_id")
    private Long pageId;

    @Column(name="browse_id")
    private Long browseId;

    @Column(name="fab")
    private Boolean fab;

    @Column(name="round")
    private Boolean round;

    @Column(name="section_id")
    private Long sectionId;

    @Transient
    @NotAudited
    private String labelValue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="label_id")
    private Label label;

    @Transient
    @NotAudited
    private Boolean visible;

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getVisibleRuleExp() {
        return visibleRuleExp;
    }

    public void setVisibleRuleExp(String visibleRuleExp) {
        this.visibleRuleExp = visibleRuleExp;
    }

    public String getEventDefinition() {
        return eventDefinition;
    }

    public void setEventDefinition(String eventDefinition) {
        this.eventDefinition = eventDefinition;
    }

    public String getButtonCode() {
        return buttonCode;
    }

    public void setButtonCode(String buttonCode) {
        this.buttonCode = buttonCode;
    }

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getButtonType() {
        return buttonType;
    }

    public void setButtonType(Integer buttonType) {
        this.buttonType = buttonType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getBrowseId() {
        return browseId;
    }

    public void setBrowseId(Long browseId) {
        this.browseId = browseId;
    }

    public Boolean getFab() {
        return fab;
    }

    public void setFab(Boolean fab) {
        this.fab = fab;
    }

    public Boolean getRound() {
        return round;
    }

    public void setRound(Boolean round) {
        this.round = round;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }
}
