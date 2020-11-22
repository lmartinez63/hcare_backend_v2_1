package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import javax.persistence.*;

@Entity
@Audited
@Table(name="auxiliar_exam")
public class AuxiliarExam extends AuditModel {
	@Id
    @GeneratedValue(generator = "auxiliar_exam_generator")
    @SequenceGenerator(
            name = "auxiliar_exam_generator",
            sequenceName = "auxiliar_exam_sequence",
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
    
    public AuxiliarExam() {
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

	public AuxiliarExam(Long id, String code, String description, Label label) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.label = label;
	}



}
