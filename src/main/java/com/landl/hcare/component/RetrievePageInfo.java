package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.MedicalAppointment;
import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.entity.UserAuthenticated;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrievePageInfo")
public class RetrievePageInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_pageId = (String)requestMap.get("pageId");
        Page page = null;
        if(s_pageId != null){
            Long l_pageId = Long.parseLong(s_pageId);
            page = pageService.findById(l_pageId);
            page.setSectionList(sectionService.getSectionsByPageCode(page.getPageCode()));
        } else {
            page = pageService.createPage();
        }
        addDataToResultMap("page",page);
    }



}
