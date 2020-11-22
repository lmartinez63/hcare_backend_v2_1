package com.landl.hcare.component;

import com.landl.hcare.entity.FieldDefinition;
import com.landl.hcare.entity.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("retrieveAllPage")
public class RetrieveAllPages extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        List<Page> pageList = pageService.findAll();

        addDataToResultMap("pageList",pageList);

    }



}
