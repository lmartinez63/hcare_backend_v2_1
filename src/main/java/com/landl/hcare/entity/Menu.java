package com.landl.hcare.entity;

import com.landl.hcare.model.AuditModel;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Audited
@Table(name="menu")
public class Menu extends AuditModel {
    @Id
    @GeneratedValue(generator = "menu_generator")
    @SequenceGenerator(
            name = "menu_generator",
            sequenceName = "menu_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;

    @Column(name="menu_code")
    private String menuCode;

    // Page(id) and DataTable(id)
    @Column(name="object_id")
    private Long objectId;

    //  /browse/allRolePageSectionFieldPage
    @Column(name="link")
    private String link;

    //  mdi-clipboard-outline
    @Column(name="icon")
    private String icon;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="label_id")
    private Label label;

    // page or browse
    @Column(name="object_type")
    private String objectType;

    @OneToMany
    @JoinColumn(name = "parent_menu_id")
    private List<Menu> childMenus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public Long getObjectId() {
        return objectId;
    }

    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public List<Menu> getChildMenus() {
        return childMenus;
    }

    public void setChildMenus(List<Menu> childMenus) {
        this.childMenus = childMenus;
    }
}
