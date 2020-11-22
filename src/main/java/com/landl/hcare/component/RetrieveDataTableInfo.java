package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.DataTable;
import com.landl.hcare.entity.Page;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveDataTableInfo")
public class RetrieveDataTableInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_dataTableId = (String)requestMap.get("dataTableId");
        DataTable dataTable = null;
        if(s_dataTableId != null){
            Long l_dataTableId = Long.parseLong(s_dataTableId);
            dataTable = dataTableService.findById(l_dataTableId);
        } else {
            dataTable = dataTableService.createDataTable();
        }
        addDataToResultMap("dataTable",dataTable);
    }



}
