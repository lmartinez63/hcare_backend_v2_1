package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("retrieveSurgeryAreaInfo")
public class RetrieveSurgeryAreaInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_surgeryAreaId = (String)requestMap.get("surgeryAreaId");
        SurgeryArea surgeryArea = null;
        if(s_surgeryAreaId != null){
            Long l_surgeryAreaId = Long.parseLong(s_surgeryAreaId);
            surgeryArea = surgeryAreaService.findById(l_surgeryAreaId);
            //Get EventList to get Availability for FullCalendar
            /*
            List<EventGroup> eventGroupList = new ArrayList<EventGroup>();
            List<Event> surgeryAreaEventList = eventService.findBySurgeryAreaId(l_surgeryAreaId);
            EventGroup surgeryAreaEventGroup = new EventGroup();
            surgeryAreaEventGroup.setEvents(surgeryAreaEventList);
            surgeryAreaEventGroup.setGroupClassName("surgeryArea");
            eventGroupList.add(surgeryAreaEventGroup);
            addDataToResultMap("surgeryAreaEventGroupList",eventGroupList);
            */
        } else {
            surgeryArea = surgeryAreaService.createSurgeryArea();
        }
        addDataToResultMap("surgeryArea",surgeryArea);
    }
}
