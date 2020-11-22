package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.FieldDefinition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("retrieveAllFieldDefinition")
public class RetrieveAllFieldDefinitions extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        List<FieldDefinition> fieldDefinitionList = fieldService.findAll();

        addDataToResultMap("fieldDefinitionList",fieldDefinitionList);

    }



}
