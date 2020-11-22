package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.RolePageSectionField;
import com.landl.hcare.entity.Role;
import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.Section;
import com.landl.hcare.entity.FieldDefinition;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveRolePageSectionField")
public class SaveRolePageSectionField extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        //Get The rolePageSectionField requested on when page has been invoked
        final RolePageSectionField rolePageSectionFieldRequested = mapper.convertValue(requestMap.get("rolePageSectionFieldRequested"), RolePageSectionField.class);
        //Get The rolePageSectionField that would like to be added
        final RolePageSectionField rolePageSectionFieldRequest = mapper.convertValue(requestMap.get("rolePageSectionField"), RolePageSectionField.class);
        RolePageSectionField rolePageSectionField = null;
        //Create condition
        if(rolePageSectionFieldRequest.getId().verifyIfIsEmpty()){
            rolePageSectionFieldRequest.setIdFromObjects();
        }
        if ((rolePageSectionFieldRequested == null || rolePageSectionFieldRequested.getId().verifyIfIsEmpty()) && !rolePageSectionFieldRequest.getId().verifyIfIsEmpty()){
            rolePageSectionField = rolePageSectionFieldRequest;
            rolePageSectionFieldService.save(rolePageSectionField);
        //Edit condition
        } else if ((!rolePageSectionFieldRequested.getId().verifyIfIsEmpty()) && !rolePageSectionFieldRequest.getId().verifyIfIsEmpty()){
            rolePageSectionFieldService.delete(rolePageSectionFieldRequested);
            rolePageSectionField = rolePageSectionFieldRequest;
            rolePageSectionFieldService.save(rolePageSectionFieldRequest);
        }


        addDataToResultMap("rolePageSectionField",rolePageSectionField);
    }



}
