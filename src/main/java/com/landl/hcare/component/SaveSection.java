package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.Section;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveSection")
public class SaveSection extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final Section sectionRequest = mapper.convertValue(requestMap.get("section"), Section.class);
        Section section = null;
        if (sectionRequest.getId() != null){
            section = sectionService.findById(sectionRequest.getId());
            copyNonNullProperties(sectionRequest, section);
        } else {
            section = sectionRequest;
        }
        sectionService.save(section);
        addDataToResultMap("section",section);
    }



}
