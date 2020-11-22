package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Audited
@Table(name="exam_bundle")
public class ExamBundle extends AuditModel {
	@Id
    @GeneratedValue(generator = "exam_bundle_generator")
    @SequenceGenerator(
            name = "exam_bundle_generator",
            sequenceName = "exam_bundle_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    private Long id;
    
	@Column(name="code")
    @Audited
    private String code;
	
	@Column(name="description", nullable = true,length = 4000)
    @Audited
    private String description;
    
	@OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="label_id")
    private Label label;
    
    @OneToMany
    @JoinColumn(name = "parent_exam_bundle_id")
    private List<ExamBundle> childExamBundles;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EXAMBUNDLE_AUXILIAREXAMS", joinColumns = {
            @JoinColumn(name = "EXAMBUNDLE_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "AUXILIAREXAM_ID") })
    private List<AuxiliarExam> auxiliarExamList;

    public ExamBundle() {
    }

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public List<ExamBundle> getChildExamBundles() {
		return childExamBundles;
	}

	public void setChildExamBundles(List<ExamBundle> childExamBundles) {
		this.childExamBundles = childExamBundles;
	}
	
	
	
	public List<AuxiliarExam> getAuxiliarExamList() {
		return auxiliarExamList;
	}

	public void setAuxiliarExamList(List<AuxiliarExam> auxiliarExamList) {
		this.auxiliarExamList = auxiliarExamList;
	}

	public ExamBundle(Long id, String code, String description, Label label, Long medicalAppointmentId,
			List<ExamBundle> childExamBundles) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.label = label;
		this.childExamBundles = childExamBundles;
	}



}
