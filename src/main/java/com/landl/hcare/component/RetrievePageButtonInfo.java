package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.DataTable;
import com.landl.hcare.entity.PageButton;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrievePageButtonInfo")
public class RetrievePageButtonInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_pageButtonId = (String)requestMap.get("pageButtonId");
        Integer i_pageId = (Integer)requestMap.get("pageId");
        Integer i_browseId = (Integer)requestMap.get("browseId");
        PageButton pageButton = null;
        if(s_pageButtonId != null){
            Long l_pageButtonId = Long.parseLong(s_pageButtonId);
            pageButton = pageButtonService.findById(l_pageButtonId);
        } else {
            Long l_pageId = i_pageId != null ? i_pageId.longValue() : null;
            Long l_browseId = i_browseId != null ? i_browseId.longValue() : null;
            pageButton = pageButtonService.createPageButton(l_pageId,l_browseId);
        }
        addDataToResultMap("pageButton",pageButton);
    }



}
