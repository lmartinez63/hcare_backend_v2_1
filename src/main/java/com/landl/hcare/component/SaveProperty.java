package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Property;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveProperty")
public class SaveProperty extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final Property propertyRequest = mapper.convertValue(requestMap.get("property"), Property.class);
        Property property = null;
        if (propertyRequest.getId() != null){
            property = propertyService.findById(propertyRequest.getId());
            copyNonNullProperties(propertyRequest, property);
        } else {
            property = propertyRequest;
        }
        propertyService.save(property);
        addDataToResultMap("property",property);
    }



}
