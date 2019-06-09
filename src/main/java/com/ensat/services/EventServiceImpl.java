package com.ensat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Product;
import com.ensat.entities.Event;
import com.ensat.repositories.ProductRepository;
import com.ensat.repositories.EventRepository;

@Service
public class EventServiceImpl implements EventService {
	private EventRepository eventRepository;
	
	@Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Iterable<Event> listAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(Integer eventId) {
        return eventRepository.findOne(eventId);
    }

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Integer eventId) {
    	eventRepository.delete(eventId);
    }
}
