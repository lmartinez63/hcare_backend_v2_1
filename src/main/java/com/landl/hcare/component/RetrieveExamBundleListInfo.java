package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Allergy;
import com.landl.hcare.entity.AuxiliarExam;
import com.landl.hcare.entity.Page;
import com.landl.hcare.entity.Property;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("retrieveExamBundleListInfo")
public class RetrieveExamBundleListInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        List<Map> examBundleList = examBundleService.convertDirectoryToFrontEndFormat(examBundleService.findAll());
        List<AuxiliarExam> tempAuxiliarExamList = new ArrayList<AuxiliarExam>(); 
        addDataToResultMap("examBundleList",examBundleList);
        addDataToResultMap("tempAuxiliarExamList",tempAuxiliarExamList);
    }



}
