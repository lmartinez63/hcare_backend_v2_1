package com.landl.hcare.entity;

import com.landl.hcare.common.DateUtils;
import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Audited
public class Event extends AuditModel {

    @Id
    @GeneratedValue(generator = "event_generator")
    @SequenceGenerator(
            name = "event_generator",
            sequenceName = "event_sequence",
            allocationSize = 1,
            initialValue = 1000
    )
    private Long id;

    @Column(name="group_id")
    @Audited
    private Long groupId;

    @Column(name="title")
    @Audited
    private String title;

    @Column(name="class_names")
    @Audited
    private String classNames;

    @Column(name="editable")
    @Audited
    private Boolean editable;

    @Column(name="overlap")
    @Audited
    private Boolean overlap;

    @Column(name="start_schedule")
    @Audited
    private Date start;

    @Column(name="end_schedule")
    @Audited
    private Date end;

    @Transient
    private String date;
    
    @Transient
    private String time;
    
    @Transient
    private int duration;
    
    
    @Column(name="surgery_area_id")
    @Audited
    private Long surgeryAreaId;

    public Event() {
    }

    public Event(Long id, Date start, Date end, Long surgeryAreaId, Long groupId, Boolean editable) {
        this.id = id;
        this.editable = editable;
        this.start = start;
        this.end = end;
        this.surgeryAreaId = surgeryAreaId;
        this.groupId = groupId;
    }
    
    @PostLoad
    private void postLoad() {
        if(this.start != null){
            this.date = DateUtils.toISO8601Date(start);
            this.time = DateUtils.toISO8601Time(start);
            this.duration = (new Long(( this.end.getTime() - this.start.getTime() ) / (60 * 1000))).intValue();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassNames() {
        return classNames;
    }

    public void setClassNames(String classNames) {
        this.classNames = classNames;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getOverlap() {
        return overlap;
    }

    public void setOverlap(Boolean overlap) {
        this.overlap = overlap;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Long getSurgeryAreaId() {
        return surgeryAreaId;
    }

    public void setSurgeryAreaId(Long surgeryAreaId) {
        this.surgeryAreaId = surgeryAreaId;
    }

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
    
    
}