package com.landl.hcare.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.landl.hcare.common.UtilityTools;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Audited
public class UserProfile {

    @Id
    @GeneratedValue(generator = "user_profile_generator")
    @SequenceGenerator(
            name = "user_profile_generator",
            sequenceName = "user_profile_sequence",
            initialValue = 1000,
            allocationSize = 1
    )
    private Long id;
    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    @Column(name="user_code")
    private String userCode;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="language")
    private String language;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Transient
    @NotAudited
    private String fullName;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="address")
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles = new HashSet<>();

    @Transient
    private Map pageSectionMap;
    
    @Transient
    private List menus;
    /*
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_PAGES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "PAGE_ID") })
    private Set<Page> pages;
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return UtilityTools.isNull(this.firstName) + " " + UtilityTools.isNull(this.lastName);
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Map getPageSectionMap() {
        return pageSectionMap;
    }

    public void setPageSectionMap(Map pageSectionMap) {
        this.pageSectionMap = pageSectionMap;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

	public List getMenus() {
		return menus;
	}

	public void setMenus(List menus) {
		this.menus = menus;
	}

    

}