package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Allergy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveAllergy")
public class SaveAllergy extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final Allergy allergyRequest = mapper.convertValue(requestMap.get("allergy"), Allergy.class);
        Allergy allergy = null;
        if (allergyRequest.getId() != null){
        	allergy = allergyService.findById(allergyRequest.getId());
            copyNonNullProperties(allergyRequest, allergy);
        } else {
        	allergy = allergyRequest;
        }
        allergyService.save(allergy);
        addDataToResultMap("allergy",allergy);
    }



}
