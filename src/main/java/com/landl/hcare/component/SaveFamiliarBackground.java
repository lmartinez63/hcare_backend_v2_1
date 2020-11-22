package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.FamiliarBackground;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveFamiliarBackground")
public class SaveFamiliarBackground extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final FamiliarBackground familiarBackgroundRequest = mapper.convertValue(requestMap.get("familiarBackground"), FamiliarBackground.class);
        FamiliarBackground familiarBackground = null;
        if (familiarBackgroundRequest.getId() != null){
        	familiarBackground = familiarBackgroundService.findById(familiarBackgroundRequest.getId());
            copyNonNullProperties(familiarBackgroundRequest, familiarBackground);
        } else {
        	familiarBackground = familiarBackgroundRequest;
        }
        familiarBackgroundService.save(familiarBackground);
        addDataToResultMap("familiarBackground",familiarBackground);
    }



}
