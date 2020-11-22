package com.landl.hcare.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RolePageSectionFieldId implements Serializable {

    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "page_id")
    private Long pageId;

    @Column(name = "section_id")
    private Long sectionId;

    @Column(name = "field_definition_id")
    private Long fieldDefinitionId;

    public RolePageSectionFieldId() {
    }

    public RolePageSectionFieldId(Long roleId, Long pageId, Long sectionId, Long fieldDefinitionId) {
        this.roleId = roleId;
        this.pageId = pageId;
        this.sectionId = sectionId;
        this.fieldDefinitionId = fieldDefinitionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getFieldDefinitionId() {
        return fieldDefinitionId;
    }

    public void setFieldDefinitionId(Long fieldDefinitionId) {
        this.fieldDefinitionId = fieldDefinitionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RolePageSectionFieldId)) return false;
        RolePageSectionFieldId that = (RolePageSectionFieldId) o;
        return Objects.equals(getRoleId(), that.getRoleId()) &&
                Objects.equals(getFieldDefinitionId(), that.getFieldDefinitionId()) &&
                Objects.equals(getSectionId(), that.getSectionId()) &&
                Objects.equals(getPageId(), that.getPageId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoleId(), getPageId(), getSectionId(), getFieldDefinitionId());
    }

    public boolean verifyIfIsEmpty(){
        return this.roleId == null ||
                this.pageId == null ||
                this.sectionId == null ||
                this.fieldDefinitionId == null;
    }
}