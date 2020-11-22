package com.landl.hcare.service;

import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.UserProfile;

import java.util.List;

public interface UserService {

    public UserProfile save(UserProfile userProfile) throws  Exception;
    public List<UserProfile> findAll() throws  Exception;
    public List<UserProfile> findByRole(String roleName) throws  Exception;
    public List<AutoCompleteField> findByRoleForAutoCompleteFields(String roleName) throws  Exception;
    public void delete(long id) throws  Exception;
    public UserProfile findOne(String username) throws  Exception;
    public UserProfile findByUsername(String username);
    public UserProfile createUserProfile() throws  Exception;
    public UserProfile getPageAndFieldsAssigned(String username)  throws  Exception;
    public UserProfile getMenuAndPageAssigned(String username)  throws  Exception;
    public UserProfile findById(Long id) throws  Exception;
}