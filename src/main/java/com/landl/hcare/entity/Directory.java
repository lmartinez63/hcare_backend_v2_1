package com.landl.hcare.entity;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.List;

@Entity
@Audited
@Table(name="directory")
public class Directory {
    @Id
    @GeneratedValue(generator = "directory_generator")
    @SequenceGenerator(
            name = "directory_generator",
            sequenceName = "directory_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @OneToMany
    @JoinColumn(name = "parent_directory_id")
    private List<Directory> childDirectories;

    @Column(name="entity_rel_column_name")
    private String entityRelColumnName;

    @Column(name="parent_column_name")
    private String parentColumnName;

    @Column(name="parent_entity_name")
    private String parentEntityName;

    @Column(name="entity_name")
    private String entityName;

    @Column(name="entity_column_name")
    private String entityColumnName;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="label_id")
    private Label label;

    @Transient
    @NotAudited
    List<Attachment> attachmentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Directory> getChildDirectories() {
        return childDirectories;
    }

    public void setChildDirectories(List<Directory> childDirectories) {
        this.childDirectories = childDirectories;
    }
    public void addChildDirectories(Directory directory) {
        this.childDirectories.add(directory);
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public void setAttachmentList(List<Attachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getParentColumnName() {
        return parentColumnName;
    }

    public void setParentColumnName(String parentColumnName) {
        this.parentColumnName = parentColumnName;
    }

    public String getEntityColumnName() {
        return entityColumnName;
    }

    public void setEntityColumnName(String entityColumnName) {
        this.entityColumnName = entityColumnName;
    }

    public String getParentEntityName() {
        return parentEntityName;
    }

    public void setParentEntityName(String parentEntityName) {
        this.parentEntityName = parentEntityName;
    }

    public String getEntityRelColumnName() {
        return entityRelColumnName;
    }

    public void setEntityRelColumnName(String entityRelColumnName) {
        this.entityRelColumnName = entityRelColumnName;
    }
}
