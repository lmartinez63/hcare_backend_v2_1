package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Audited
public class SurgeryType extends AuditModel {

    @Id
    @GeneratedValue(generator = "surgery_type_generator")
    @SequenceGenerator(
            name = "surgery_type_generator",
            sequenceName = "surgery_type_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    private Long id;

    @Column(name="code")
    @Audited
    private String code;

    @Column(name="duration_minutes")
    @Audited
    private Integer durationMinutes;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="label_id")
    private Label label;

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

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}