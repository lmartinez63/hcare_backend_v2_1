package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.common.DateUtils;
import com.landl.hcare.entity.Event;
import com.landl.hcare.entity.EventGroup;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component("getAvailableDatetimeListBySurgeryType")
public class GetAvailableDatetimeListBySurgeryType extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final Date requiredDate = mapper.convertValue(requestMap.get("requiredDate"), Date.class);
        final Integer surgeryTypeId = mapper.convertValue(requestMap.get("surgeryTypeId"), Integer.class);

        List<EventGroup> eventGroupList = new ArrayList<EventGroup>();
        List<Event> availableDatetimeList = medicalSurgeryService.findTimeAvailableBySurgeryType(surgeryTypeId.longValue(),requiredDate);
        Map<Long, List<Event>> availableDatetimeMap = availableDatetimeList.stream().collect(Collectors.groupingBy(Event::getSurgeryAreaId));
        for (Map.Entry<Long, List<Event>> availableDatetimeListEntry : availableDatetimeMap.entrySet()) {
            EventGroup surgeryAreaEventGroup = new EventGroup();
            surgeryAreaEventGroup.setId(availableDatetimeListEntry.getKey());
            surgeryAreaEventGroup.setEvents(availableDatetimeListEntry.getValue());
            //TODO improve
            surgeryAreaEventGroup.setGroupClassName("surgeryArea");
            eventGroupList.add(surgeryAreaEventGroup);
        }
        addDataToResultMap("eventGroupList",eventGroupList);
        addDataToResultMap("defaultDateCalendar", DateUtils.toISO8601Date(requiredDate));
    }



}
