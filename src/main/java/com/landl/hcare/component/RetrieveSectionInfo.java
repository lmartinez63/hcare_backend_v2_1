package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.Section;
import com.landl.hcare.entity.UserAuthenticated;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveSectionInfo")
public class RetrieveSectionInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_sectionId = (String)requestMap.get("sectionId");
        Section section = null;
        if(s_sectionId != null){
            Long l_sectionId = Long.parseLong(s_sectionId);
            section = sectionService.findById(l_sectionId);
            section.setFieldDefinitionList(fieldService.getFieldsBySectionCode(section.getSectionCode()));
        } else {
            section = sectionService.createSection();
        }
        addDataToResultMap("section",section);
    }



}
