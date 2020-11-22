package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.Property;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrievePropertyInfo")
public class RetrievePropertyInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_propertyId = (String)requestMap.get("propertyId");
        Property property = null;
        if(s_propertyId != null){
            Long l_propertyId = Long.parseLong(s_propertyId);
            property = propertyService.findById(l_propertyId);
        } else {
            property = propertyService.createProperty();
        }
        addDataToResultMap("property",property);
    }



}
