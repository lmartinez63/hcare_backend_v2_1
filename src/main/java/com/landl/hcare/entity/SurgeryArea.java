package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Audited
public class SurgeryArea extends AuditModel {

    @Id
    @GeneratedValue(generator = "surgery_area_generator")
    @SequenceGenerator(
            name = "surgery_area_generator",
            sequenceName = "surgery_area_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    private Long id;

    @Column(name="surgery_area_code")
    @Audited
    private String surgeryAreaCode;

    @Column(name="activation_status")
    @Audited
    private Boolean activationStatus;

    //For FullCalendar
    //@Transient
    //private List<EventGroup> eventList;
    
    //For V-Calendar
    @Transient
    private List<Event> eventList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurgeryAreaCode() {
        return surgeryAreaCode;
    }

    public void setSurgeryAreaCode(String surgeryAreaCode) {
        this.surgeryAreaCode = surgeryAreaCode;
    }

    public Boolean getActivationStatus() {
        return activationStatus;
    }

    public void setActivationStatus(Boolean activationStatus) {
        this.activationStatus = activationStatus;
    }

	public List<Event> getEventList() {
		return eventList;
	}

	public void setEventList(List<Event> eventList) {
		this.eventList = eventList;
	}
    
    
}