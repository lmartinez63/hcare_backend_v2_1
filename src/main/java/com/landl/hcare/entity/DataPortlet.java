package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Audited
@Table(name="data_portlet")
public class DataPortlet extends AuditModel {
    @Id
    @GeneratedValue(generator = "data_portlet_generator")
    @SequenceGenerator(
            name = "data_portlet_generator",
            sequenceName = "data_portlet_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="data_portlet_code")
    private String dataPortletCode;

    @Column(name="data_portlet_type")
    private String dataPortletType;

    @Column(name="query_string",length = 10485760)
    private String queryString;

    //Map one to one association between Person and Address
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="label_id")
    private Label label;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataPortletCode() {
        return dataPortletCode;
    }

    public void setDataPortletCode(String dataPortletCode) {
        this.dataPortletCode = dataPortletCode;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public Label getLabel() {
        return label;
    }

    public String getDataPortletType() {
        return dataPortletType;
    }

    public void setDataPortletType(String dataPortletType) {
        this.dataPortletType = dataPortletType;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
}
