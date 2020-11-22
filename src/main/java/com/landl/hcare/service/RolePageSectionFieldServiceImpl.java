package com.landl.hcare.service;

import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.*;
import com.landl.hcare.repository.PageRepository;
import com.landl.hcare.repository.RolePageSectionFieldRepository;
import com.landl.hcare.rule.RuleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RolePageSectionFieldServiceImpl implements RolePageSectionFieldService {

    @Autowired
    RolePageSectionFieldRepository rolePageSectionFieldRepository;

    @Autowired
    RoleService roleService;

    @Autowired
    PageService pageService;

    @Autowired
    SectionService sectionService;

    @Autowired
    FieldService fieldService;

    public RolePageSectionField save(RolePageSectionField rolePageSectionField) throws Exception{
        return rolePageSectionFieldRepository.save(rolePageSectionField);
    }

    public void delete(RolePageSectionField rolePageSectionField) throws Exception{
        rolePageSectionFieldRepository.delete(rolePageSectionField);
    }

    public List<RolePageSectionField> findAll(){
        return rolePageSectionFieldRepository.findAll();
    }

    public RolePageSectionField findById(RolePageSectionFieldId rolePageSectionFieldId){
        return rolePageSectionFieldRepository.findById(rolePageSectionFieldId).get();
    }

    public void getEntities(RolePageSectionField rolePageSectionField){
        rolePageSectionField.setRole(roleService.findById(rolePageSectionField.getId().getRoleId()));
        rolePageSectionField.setPage(pageService.findById(rolePageSectionField.getId().getPageId()));
        rolePageSectionField.setSection(sectionService.findById(rolePageSectionField.getId().getSectionId()));
        rolePageSectionField.setFieldDefinition(fieldService.findById(rolePageSectionField.getId().getFieldDefinitionId()));
    }

    public RolePageSectionField createRolePageSectionField(){
        RolePageSectionFieldId rolePageSectionFieldId = new RolePageSectionFieldId();
        RolePageSectionField rolePageSectionField =  new RolePageSectionField(rolePageSectionFieldId);
        rolePageSectionField.setRole( new Role());
        rolePageSectionField.setPage( new Page());
        rolePageSectionField.setSection( new Section());
        rolePageSectionField.setFieldDefinition( new FieldDefinition());
        return rolePageSectionField;
    }


}
