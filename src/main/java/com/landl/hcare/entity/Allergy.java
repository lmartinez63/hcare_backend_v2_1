package com.landl.hcare.entity;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;

@Entity
@Audited
@Table(name="allergy")
public class Allergy extends AuditModel {
	@Id
    @GeneratedValue(generator = "allergy_generator")
    @SequenceGenerator(
            name = "allergy_generator",
            sequenceName = "allergy_sequence",
            allocationSize = 1,
            initialValue = 1
    )
    private Long id;

    @Column(name="code")
    private String code;

    //Should be stored in label
    @Column(name="description")
    private String description;

    public Allergy() {
    }

    public Allergy(Long id, String code, String description) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
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
    

}
