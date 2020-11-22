package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="validation")
public class Validation extends AuditModel {
    @Id
    @GeneratedValue(generator = "validation_generator")
    @SequenceGenerator(
            name = "validation_generator",
            sequenceName = "validation_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    //Map one to one association between Person and Address
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="label_id")
    private Label label;

    @Column(name="validation_type")
    private Integer validationType;

    @Transient
    private String validationMessage;

    @JoinColumns({
            @JoinColumn(name = "role_page_section_field_role_id" , referencedColumnName = "role_id" ),
            @JoinColumn(name = "role_page_section_field_page_id" , referencedColumnName = "page_id" ),
            @JoinColumn(name = "role_page_section_field_section_id" , referencedColumnName = "section_id" ),
            @JoinColumn(name = "role_page_section_field_field_definition_id" , referencedColumnName = "field_definition_id" )
    })
    @ManyToOne
    private RolePageSectionField rolePageSectionField;

    public Validation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValidationType() {
        return validationType;
    }

    public void setValidationType(Integer validationType) {
        this.validationType = validationType;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
