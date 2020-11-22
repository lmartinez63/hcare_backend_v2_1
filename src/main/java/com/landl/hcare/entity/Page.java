package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;


import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Audited
@Table(name="page")
public class Page extends AuditModel {
    @Id
    @GeneratedValue(generator = "page_generator")
    @SequenceGenerator(
            name = "page_generator",
            sequenceName = "page_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="page_code")
    private String pageCode;

    @Column(name="page_mode")
    private String pageMode;

    @Column(name="entity")
    private String entity;

    @Column(name="visible_rule_exp")
    private String visibleRuleExp;

    @Column(name="title_definition")
    private String titleDefinition;

    @Column(name="co_title_definition")
    private String coTitleDefinition;

    @Column(name="sub_title_definition")
    private String subTitleDefinition;
    
    
    @Column(name="header_text")
    private String headerText;
    
    @Column(name="header_text_1")
    private String headerText1;
    
    @Column(name="header_text_2")
    private String headerText2;
    
    @Column(name="header_text_3")
    private String headerText3;
    
    @Column(name="header_text_4")
    private String headerText4;
    
    @Column(name="header_text_5")
    private String headerText5;
    
    @Column(name="header_text_6")
    private String headerText6;
    
    @Column(name="header_text_7")
    private String headerText7;
    
    @Column(name="header_text_8")
    private String headerText8;
    
    @Column(name="header_text_9")
    private String headerText9;
    
    @Column(name="size")
    private String size;

    @Transient
    @NotAudited
    private Boolean visible;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="label_id")
    private Label label;

    @OneToMany
    @OrderBy("display_order")
    @JoinColumn(name = "page_id")
    private List<PageButton> pageButtons;
    /*
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "page_field", joinColumns = {
            @JoinColumn(name = "page_code", referencedColumnName ="page_code" ) }, inverseJoinColumns = {
            @JoinColumn(name = "field_definition_code", referencedColumnName ="field_definition_code") })
    */
    @Transient
    private List<Section> sectionList;

    @Transient
    private Map<String,Section> sectionMap;

    /*
    @Transient
    private List<FieldDefinition> fieldDefinitionList;
    */

    public Page() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    public String getVisibleRuleExp() {
        return visibleRuleExp;
    }

    public void setVisibleRuleExp(String visibleRuleExp) {
        this.visibleRuleExp = visibleRuleExp;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Map<String, Section> getSectionMap() {
        return sectionMap;
    }

    public void setSectionMap(Map<String, Section> sectionMap) {
        this.sectionMap = sectionMap;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public List<PageButton> getPageButtons() {
        return pageButtons;
    }

    public void setPageButtons(List<PageButton> pageButtons) {
        this.pageButtons = pageButtons;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getTitleDefinition() {
        return titleDefinition;
    }

    public void setTitleDefinition(String titleDefinition) {
        this.titleDefinition = titleDefinition;
    }

    public String getSubTitleDefinition() {
        return subTitleDefinition;
    }

    public void setSubTitleDefinition(String subTitleDefinition) {
        this.subTitleDefinition = subTitleDefinition;
    }

    public String getCoTitleDefinition() {
        return coTitleDefinition;
    }

    public void setCoTitleDefinition(String coTitleDefinition) {
        this.coTitleDefinition = coTitleDefinition;
    }

    public String getPageMode() {
        return pageMode;
    }

    public void setPageMode(String pageMode) {
        this.pageMode = pageMode;
    }

	public String getHeaderText() {
		return headerText;
	}

	public void setHeaderText(String headerText) {
		this.headerText = headerText;
	}

	public String getHeaderText1() {
		return headerText1;
	}

	public void setHeaderText1(String headerText1) {
		this.headerText1 = headerText1;
	}

	public String getHeaderText2() {
		return headerText2;
	}

	public void setHeaderText2(String headerText2) {
		this.headerText2 = headerText2;
	}

	public String getHeaderText3() {
		return headerText3;
	}

	public void setHeaderText3(String headerText3) {
		this.headerText3 = headerText3;
	}

	public String getHeaderText4() {
		return headerText4;
	}

	public void setHeaderText4(String headerText4) {
		this.headerText4 = headerText4;
	}

	public String getHeaderText5() {
		return headerText5;
	}

	public void setHeaderText5(String headerText5) {
		this.headerText5 = headerText5;
	}

	public String getHeaderText6() {
		return headerText6;
	}

	public void setHeaderText6(String headerText6) {
		this.headerText6 = headerText6;
	}

	public String getHeaderText7() {
		return headerText7;
	}

	public void setHeaderText7(String headerText7) {
		this.headerText7 = headerText7;
	}

	public String getHeaderText8() {
		return headerText8;
	}

	public void setHeaderText8(String headerText8) {
		this.headerText8 = headerText8;
	}

	public String getHeaderText9() {
		return headerText9;
	}

	public void setHeaderText9(String headerText9) {
		this.headerText9 = headerText9;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
    
	
    
}
