package com.landl.hcare.service;

import com.landl.hcare.entity.Event;

import java.util.Date;
import java.util.List;

public interface EventService {

    public Event save(Event event) throws Exception;

    public List<Event> findAll() throws Exception;

    public List<Event> findBySurgeryAreaId(Long surgeryAreaId) throws Exception;

    public List<Event> getAvailableDatetimesInSurgeryArea(Date requiredDate, Long surgeryAreaId, Integer durationMinutes) throws Exception;

    public List<Event> getAvailableDatetimesBySurgeryType(Date requiredDate, Integer durationMinutes) throws Exception;

    public Event findById(Long eventId) throws Exception;

    public Event createEventFromSurgeryArea(Long surgeryAreaId) throws  Exception;

}
