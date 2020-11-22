package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("savePage")
public class SavePage extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final Page pageRequest = mapper.convertValue(requestMap.get("page"), Page.class);
        Page page = null;
        if (pageRequest.getId() != null){
            page = pageService.findById(pageRequest.getId());
            copyNonNullProperties(pageRequest, page);
        } else {
            page = pageRequest;
        }
        pageService.save(page);
        addDataToResultMap("page",page);
    }



}
