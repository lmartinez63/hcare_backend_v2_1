package com.landl.hcare.service;


import com.landl.hcare.entity.RolePageSectionField;
import com.landl.hcare.entity.RolePageSectionFieldId;

import java.util.List;

public interface RolePageSectionFieldService {

    public RolePageSectionField save(RolePageSectionField rolePageSectionField) throws  Exception;

    public void delete(RolePageSectionField rolePageSectionField) throws  Exception;

    public List<RolePageSectionField> findAll();

    public RolePageSectionField findById(RolePageSectionFieldId rolePageSectionFieldId);

    public void getEntities(RolePageSectionField rolePageSectionField);

    public RolePageSectionField createRolePageSectionField();

}
