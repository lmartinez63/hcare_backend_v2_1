package com.landl.hcare.service;
import com.landl.hcare.common.DateUtils;
import com.landl.hcare.entity.AutoCompleteField;
import com.landl.hcare.entity.Event;
import com.landl.hcare.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventRepository eventRepository;

    public Event save(Event event) throws Exception{
        return eventRepository.save(event);
    }

    public List<Event> findAll() throws Exception{
        return eventRepository.findAll();
    }

    public List<Event> findBySurgeryAreaId(Long surgeryAreaId) throws Exception{
        //return eventRepository.findBySurgeryAreaId(surgeryAreaId);
    	return eventRepository.findBySurgeryAreaIdAndStartBetween(surgeryAreaId, DateUtils.getFirstDateOfWeek(new Date()), DateUtils.getLastDateOfWeek(new Date()));
    }

    public List<Event> getAvailableDatetimesInSurgeryArea(Date requiredDate, Long surgeryAreaId, Integer durationMinutes) throws Exception{
        List<AutoCompleteField> list = new ArrayList<>();
        List<Event> eventList = new ArrayList<>();
        // To work with autocomplete or combobox
        // eventRepository.getAvailableDatetimesInSurgeryArea(DateUtils.toISO8601Date(requiredDate), surgeryAreaId, durationMinutes).iterator().forEachRemaining(u -> list.add(new AutoCompleteField((String)u[0],u[1])));
        //eventRepository.getAvailableDatesInSurgeryArea(DateUtils.toISO8601Date(requiredDate), surgeryAreaId, durationMinutes).iterator().forEachRemaining(u -> eventList.add(new Event(null,(Date)u[0],(Date)u[1],((BigInteger)u[2]).longValue(),false)));

        return eventList;
    }

    public List<Event> getAvailableDatetimesBySurgeryType(Date requiredDate, Integer durationMinutes) throws Exception{
        List<AutoCompleteField> list = new ArrayList<>();
        List<Event> eventList = new ArrayList<>();
        // To work with autocomplete or combobox
        // eventRepository.getAvailableDatetimesInSurgeryArea(DateUtils.toISO8601Date(requiredDate), surgeryAreaId, durationMinutes).iterator().forEachRemaining(u -> list.add(new AutoCompleteField((String)u[0],u[1])));
        eventRepository.getAvailableDatesBySurgeryType(DateUtils.toISO8601Date(requiredDate), durationMinutes).iterator().forEachRemaining(u -> eventList.add(new Event(null,(Date)u[0],(Date)u[1],((BigInteger)u[2]).longValue(), ((BigInteger)u[2]).longValue(),false)));

        return eventList;
    }


    public Event findById(Long eventId) throws Exception{
        return eventRepository.findById(eventId).get();
    }

    public Event createEventFromSurgeryArea(Long surgeryAreaId) throws  Exception{
        Event event = new Event();
        event.setSurgeryAreaId(surgeryAreaId);
        event.setOverlap(false);
        event.setGroupId(surgeryAreaId);
        return event;
    }
}
