package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.DataColumn;
import com.landl.hcare.entity.DataTable;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("retrieveDataColumnInfo")
public class RetrieveDataColumnInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_dataColumnId = (String)requestMap.get("dataColumnId");
        Integer i_dataTableId = (Integer)requestMap.get("dataTableId");
        DataColumn dataColumn = null;
        if(s_dataColumnId != null){
            Long l_dataColumnId = Long.parseLong(s_dataColumnId);
            dataColumn = dataColumnService.findById(l_dataColumnId);
        } else {
            Long l_dataTableId = i_dataTableId.longValue();
            dataColumn = dataColumnService.createDataColumnFromDataTable(l_dataTableId);
        }
        addDataToResultMap("dataColumn",dataColumn);
    }



}
