package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.RolePageSectionField;
import com.landl.hcare.entity.RolePageSectionFieldId;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("deleteRolePageSectionField")
public class DeleteRolePageSectionField extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        //Get The rolePageSectionField that would like to be added
        final Long roleId = ((Integer)requestMap.get("roleId")).longValue();
        final Long pageId = ((Integer)requestMap.get("pageId")).longValue();
        final Long sectionId = ((Integer)requestMap.get("sectionId")).longValue();
        final Long fieldDefinitionId = ((Integer)requestMap.get("fieldDefinitionId")).longValue();
        RolePageSectionFieldId rolePageSectionFieldId = new RolePageSectionFieldId(roleId,pageId,sectionId,fieldDefinitionId);
        RolePageSectionField rolePageSectionField = new RolePageSectionField(rolePageSectionFieldId);
        rolePageSectionFieldService.delete(rolePageSectionField);
    }
}
