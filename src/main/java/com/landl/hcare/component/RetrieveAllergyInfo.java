package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Allergy;
import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.Property;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveAllergyInfo")
public class RetrieveAllergyInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_allergyId = (String)requestMap.get("allergyId");
        Allergy allergy = null;
        if(s_allergyId != null){
            Long l_allergyId = Long.parseLong(s_allergyId);
            allergy = allergyService.findById(l_allergyId);
        } else {
        	allergy = allergyService.createAllergy();
        }
        addDataToResultMap("allergy",allergy);
    }



}
