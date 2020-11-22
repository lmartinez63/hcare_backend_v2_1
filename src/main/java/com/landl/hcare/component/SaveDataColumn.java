package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.DataColumn;
import com.landl.hcare.entity.DataTable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("saveDataColumn")
public class SaveDataColumn extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final DataColumn dataColumnRequest = mapper.convertValue(requestMap.get("dataColumn"), DataColumn.class);
        DataColumn dataColumn;
        if(dataColumnRequest.getId() != null) {
            dataColumn = dataColumnService.findById(dataColumnRequest.getId());
            copyNonNullProperties(dataColumnRequest, dataColumn);
        } else {
            dataColumn = dataColumnRequest;
        }
        dataColumnService.save(dataColumn);
        addDataToResultMap("dataColumn",dataColumn);
    }



}
