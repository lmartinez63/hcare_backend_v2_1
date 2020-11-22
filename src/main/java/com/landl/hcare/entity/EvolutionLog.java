package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Entity
@Audited
public class EvolutionLog extends AuditModel {

    @Id
    @GeneratedValue(generator = "evolution_log_generator")
    @SequenceGenerator(
            name = "evolution_log_generator",
            sequenceName = "evolution_log_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="evolution_datetime")
    @Audited
    private Date evolutionDatetime;

    @Column(name="evolution_notes",length = 4000, nullable = true)
    private String evolutionNotes;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="registered_by")
    private UserProfile registeredBy;

    @Column(name="medical_surgery_id")
    private Long medicalSurgeryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getEvolutionDatetime() {
        return evolutionDatetime;
    }

    public void setEvolutionDatetime(Date evolutionDatetime) {
        this.evolutionDatetime = evolutionDatetime;
    }

    public String getEvolutionNotes() {
        return evolutionNotes;
    }

    public void setEvolutionNotes(String evolutionNotes) {
        this.evolutionNotes = evolutionNotes;
    }

    public Long getMedicalSurgeryId() {
        return medicalSurgeryId;
    }

    public void setMedicalSurgeryId(Long medicalSurgeryId) {
        this.medicalSurgeryId = medicalSurgeryId;
    }

    public UserProfile getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(UserProfile registeredBy) {
        this.registeredBy = registeredBy;
    }
}