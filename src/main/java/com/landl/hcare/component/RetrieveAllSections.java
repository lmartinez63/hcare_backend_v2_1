package com.landl.hcare.component;

import com.landl.hcare.entity.FieldDefinition;
import com.landl.hcare.entity.Section;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("retrieveAllSection")
public class RetrieveAllSections extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        List<Section> sectionList = sectionService.findAll();

        addDataToResultMap("sectionList",sectionList);

    }



}
