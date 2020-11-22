package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.DataColumn;
import com.landl.hcare.entity.DataTable;
import com.landl.hcare.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveDataTable")
public class SaveDataTable extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final DataTable dataTableRequest = mapper.convertValue(requestMap.get("dataTable"), DataTable.class);
        DataTable dataTable;
        if(dataTableRequest.getId() != null) {
            dataTable = dataTableService.findById(dataTableRequest.getId());
            copyNonNullProperties(dataTableRequest, dataTable);
        } else {
            dataTable = dataTableRequest;
        }
        dataTableService.save(dataTable);
        addDataToResultMap("dataTable",dataTable);
    }



}
