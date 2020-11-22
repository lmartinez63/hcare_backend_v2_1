package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.Event;
import com.landl.hcare.entity.EventGroup;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component("getAvailableDatetimeListOnSurgeryArea")
public class GetAvailableDatetimeListOnSurgeryArea extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final Date requiredDate = mapper.convertValue(requestMap.get("requiredDate"), Date.class);
        final Integer surgeryTypeId = mapper.convertValue(requestMap.get("surgeryTypeId"), Integer.class);
        final Integer surgeryAreaId = mapper.convertValue(requestMap.get("surgeryAreaId"), Integer.class);

        List<EventGroup> eventGroupList = new ArrayList<EventGroup>();
        List<Event> availableDatetimeList = medicalSurgeryService.findTimeAvailableSurgeryArea(surgeryAreaId.longValue(),surgeryTypeId.longValue(),requiredDate);
        EventGroup surgeryAreaEventGroup = new EventGroup();
        surgeryAreaEventGroup.setEvents(availableDatetimeList);
        surgeryAreaEventGroup.setGroupClassName("surgeryArea");
        eventGroupList.add(surgeryAreaEventGroup);
        addDataToResultMap("eventGroupList",eventGroupList);
    }



}
