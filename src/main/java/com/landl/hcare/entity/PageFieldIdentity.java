package com.landl.hcare.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Embeddable
public class PageFieldIdentity implements Serializable {

    @Column(name="page_code")
    private String pageCode;

    @Column(name="field_definition_code")
    private String fieldDefinitionCode;

    public PageFieldIdentity() { }

    public PageFieldIdentity(String pageCode, String fieldDefinitionCode) {
        this.pageCode = pageCode;
        this.fieldDefinitionCode = fieldDefinitionCode;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public String getFieldDefinitionCode() {
        return fieldDefinitionCode;
    }

    public void setFieldDefinitionCode(String fieldDefinitionCode) {
        this.fieldDefinitionCode = fieldDefinitionCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageFieldIdentity that = (PageFieldIdentity) o;

        if (!pageCode.equals(that.pageCode)) return false;
        return fieldDefinitionCode.equals(that.fieldDefinitionCode);
    }

    @Override
    public int hashCode() {
        return 31 * pageCode.hashCode() + fieldDefinitionCode.hashCode();
    }
}
