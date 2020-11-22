package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.landl.hcare.common.DateUtils;
import com.landl.hcare.common.UtilityTools;
import com.landl.hcare.entity.Event;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.Map;

@Component("retrieveEventInfo")
public class RetrieveEventInfo extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        String s_eventId = (String)requestMap.get("eventId");
        Event event = null;

        if(s_eventId != null){
            Long l_eventId = Long.parseLong(s_eventId);
            event = eventService.findById(l_eventId);
        } else {
            Integer i_surgeryAreaId = (Integer)requestMap.get("surgeryAreaId");
            if(i_surgeryAreaId != null){
                Long l_surgeryAreaId = i_surgeryAreaId.longValue();
                event = eventService.createEventFromSurgeryArea(l_surgeryAreaId);
            }
        }
        //Set schedule values
        String s_start = (String)requestMap.get("start");
        Date d_start;
        if(!UtilityTools.isEmpty(s_start)){
            d_start = DateUtils.fromISO8601(s_start);
            //odt_start = OffsetDateTime.parse(s_start, DateTimeFormatter.ISO_ZONED_DATE_TIME);
            event.setStart(d_start);
        }

        String s_end = (String)requestMap.get("end");
        Date d_end;
        if(!UtilityTools.isEmpty(s_end)){
            d_end = DateUtils.fromISO8601(s_end);
            //odt_end = OffsetDateTime.parse(s_end, DateTimeFormatter.ISO_ZONED_DATE_TIME);
            event.setEnd(d_end);
        }
        addDataToResultMap("event",event);
    }
}
