package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.Patient;
import com.landl.hcare.entity.SurgeryArea;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component("getSurgeryAreaListByRequiredDate")
public class GetSurgeryAreaListByRequiredDate extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final Date requiredDate = mapper.convertValue(requestMap.get("requiredDate"), Date.class);
        final Integer surgeryTypeId = mapper.convertValue(requestMap.get("surgeryTypeId"), Integer.class);
        List<SurgeryArea> surgeryAreaList = surgeryAreaService.findAvailableSurgeryArea(surgeryTypeId.longValue(),requiredDate);
        addDataToResultMap("surgeryAreaList",surgeryAreaList);
    }



}
