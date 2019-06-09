package com.ensat.services;

import com.ensat.entities.Event;

public interface EventService {

    Iterable<Event> listAllEvent();

    Event getEventById(Integer eventId);

    Event saveEvent(Event event);

    void deleteEvent(Integer eventId);
	
}
