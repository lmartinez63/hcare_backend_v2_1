package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;

import javax.persistence.*;

@Entity
@Table(name="page_field")
public class PageField{


    @EmbeddedId
    private PageFieldIdentity pageFieldIdentity;


    public PageField() {
    }

    public PageField(PageFieldIdentity pageFieldIdentity) {
        this.pageFieldIdentity = pageFieldIdentity;
    }

}
