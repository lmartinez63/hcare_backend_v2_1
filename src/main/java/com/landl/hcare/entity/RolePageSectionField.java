package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.List;

@Entity
@Audited
@Table(name="role_page_section_field")
public class RolePageSectionField  extends AuditModel {

    @EmbeddedId
    private RolePageSectionFieldId id;

    @Transient
    @NotAudited
    private Role role;

    @Transient
    @NotAudited
    private Page page;

    @Transient
    @NotAudited
    private Section section;

    @Transient
    @NotAudited
    private FieldDefinition fieldDefinition;

    //Map one to one association between Person and Address

    public RolePageSectionField() {
    }

    public RolePageSectionField(RolePageSectionFieldId id) {
        this.id = id;
    }

    public RolePageSectionFieldId getId() {
        return id;
    }

    public void setId(RolePageSectionFieldId id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public FieldDefinition getFieldDefinition() {
        return fieldDefinition;
    }

    public void setFieldDefinition(FieldDefinition fieldDefinition) {
        this.fieldDefinition = fieldDefinition;
    }

    public void setIdFromObjects() {
        if( this.page != null && this.section != null && this.fieldDefinition != null && this.role != null){
            setId(new RolePageSectionFieldId(
                    this.role.getId(),
                    this.page.getId(),
                    this.section.getId(),
                    this.fieldDefinition.getId()
                    ));
        }
    }
}