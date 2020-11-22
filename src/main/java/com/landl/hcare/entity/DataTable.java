package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Audited
@Table(name="data_table")
public class DataTable extends AuditModel {
    @Id
    @GeneratedValue(generator = "data_table_generator")
    @SequenceGenerator(
            name = "data_table_generator",
            sequenceName = "data_table_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="data_table_code")
    private String dataTableCode;

    @Column(name="query_string",length = 10485760)
    private String queryString;

    @Column(name="data_table_name")
    private String dataTableName;

    /*
    Remove auto foring key
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "dataTable")
    */

    @OneToMany
    @OrderBy("display_order")
    @JoinColumn(name = "browse_id")
    private List<PageButton> pageButtons;

    @Transient
    @NotAudited
    private List<DataColumn> dataColumns = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "data_table_id")
    private Set<DataRowButton> dataRowButtons;

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

    public String getDataTableCode() {
        return dataTableCode;
    }

    public void setDataTableCode(String dataTableCode) {
        this.dataTableCode = dataTableCode;
    }

    public String getDataTableName() {
        return dataTableName;
    }

    public void setDataTableName(String dataTableName) {
        this.dataTableName = dataTableName;
    }

    public List<DataColumn> getDataColumns() {
        return dataColumns;
    }

    public void setDataColumns(List<DataColumn> dataColumns) {
        this.dataColumns = dataColumns;
    }

    public Set<DataRowButton> getDataRowButtons() {
        return dataRowButtons;
    }

    public void setDataRowButtons(Set<DataRowButton> dataRowButtons) {
        this.dataRowButtons = dataRowButtons;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public List<PageButton> getPageButtons() {
        return pageButtons;
    }

    public void setPageButtons(List<PageButton> pageButtons) {
        this.pageButtons = pageButtons;
    }
}
