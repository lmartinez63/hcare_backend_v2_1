package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.FieldDefinition;
import com.landl.hcare.entity.RolePageSectionField;
import com.landl.hcare.entity.RolePageSectionFieldId;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveRolePageSectionFieldInfo")
public class RetrieveRolePageSectionFieldInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_roleId = (String)requestMap.get("roleId");
        String s_pageId = (String)requestMap.get("pageId");
        String s_sectionId = (String)requestMap.get("sectionId");
        String s_fieldDefinitionId = (String)requestMap.get("fieldDefinitionId");
        RolePageSectionField rolePageSectionField = null;

        if(s_roleId != null && s_pageId != null && s_sectionId != null && s_fieldDefinitionId != null){
            RolePageSectionFieldId rolePageSectionFieldId = new RolePageSectionFieldId(
                    Long.parseLong(s_roleId),
                    Long.parseLong(s_pageId),
                    Long.parseLong(s_sectionId),
                    Long.parseLong(s_fieldDefinitionId)
                    );
            rolePageSectionField = rolePageSectionFieldService.findById(rolePageSectionFieldId);
            rolePageSectionFieldService.getEntities(rolePageSectionField);
        } else {
            rolePageSectionField = rolePageSectionFieldService.createRolePageSectionField();
        }

        addDataToResultMap("rolePageSectionField",rolePageSectionField);

    }



}
