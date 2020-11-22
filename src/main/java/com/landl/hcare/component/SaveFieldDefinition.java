package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.FieldDefinition;
import com.landl.hcare.entity.Section;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveFieldDefinition")
public class SaveFieldDefinition extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final FieldDefinition fieldDefinitionRequest = mapper.convertValue(requestMap.get("fieldDefinition"), FieldDefinition.class);
        FieldDefinition fieldDefinition = null;
        if (fieldDefinitionRequest.getId() != null){
            fieldDefinition = fieldService.findById(fieldDefinitionRequest.getId());
            copyNonNullProperties(fieldDefinitionRequest, fieldDefinition);
        } else {
            fieldDefinition = fieldDefinitionRequest;
        }
        fieldService.save(fieldDefinition);
        addDataToResultMap("fieldDefinition",fieldDefinition);
    }



}
