package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.PageButton;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("savePageButton")
public class SavePageButton extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final PageButton pageButtonRequest = mapper.convertValue(requestMap.get("pageButton"), PageButton.class);
        PageButton pageButton = null;
        if (pageButtonRequest.getId() != null){
            pageButton = pageButtonService.findById(pageButtonRequest.getId());
            copyNonNullProperties(pageButtonRequest, pageButton);
        } else {
            pageButton = pageButtonRequest;
        }
        pageButtonService.save(pageButton);
        addDataToResultMap("pageButton",pageButton);
    }



}
