package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Label;
import com.landl.hcare.entity.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveLabelInfo")
public class RetrieveLabelInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_labelId = (String)requestMap.get("labelId");
        Label label = null;
        if(s_labelId != null){
            Long l_labelId = Long.parseLong(s_labelId);
            label = labelService.findById(l_labelId);
        } else {
            label = labelService.createLabel();
        }
        addDataToResultMap("label",label);
    }



}
