package com.landl.hcare.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.landl.hcare.entity.Event;
import com.landl.hcare.entity.SurgeryArea;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;

@Component("saveEvent")
public class SaveEvent extends CustomProcess {

    public void executeCustomProcess(Map<String, Object> requestMap) throws Exception{

        //final ObjectMapper mapper = new ObjectMapper(); // jackson's objectmapper
        final ObjectMapper mapper = new ObjectMapper();; // jackson's objectmapper
        final Event eventRequest = mapper.convertValue(requestMap.get("event"), Event.class);
        Event event = null;
        if (eventRequest.getId() != null){
            event = eventService.findById(eventRequest.getId());
            copyNonNullProperties(eventRequest, event);
        } else {
            event = eventRequest;
        }
        Event eventSaved = eventService.save(event);
        addDataToResultMap("event",eventSaved);
        //
    }



}
