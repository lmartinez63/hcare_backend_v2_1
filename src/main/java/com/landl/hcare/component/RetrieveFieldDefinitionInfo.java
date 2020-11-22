package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.FieldDefinition;
import com.landl.hcare.entity.Section;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveFieldDefinitionInfo")
public class RetrieveFieldDefinitionInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_fieldDefinitionId = (String)requestMap.get("fieldDefinitionId");
        FieldDefinition fieldDefinition = null;
        if(s_fieldDefinitionId != null){
            Long l_fieldDefinitionId = Long.parseLong(s_fieldDefinitionId);
            fieldDefinition = fieldService.findById(l_fieldDefinitionId);
        } else {
            fieldDefinition = fieldService.createFieldDefinition();
        }
        addDataToResultMap("fieldDefinition",fieldDefinition);

    }



}
