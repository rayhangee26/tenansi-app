package com.ensat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.Event;
import com.ensat.services.EventService;

@Controller
public class EventController {
	private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * List all event.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("events", eventService.listAllEvent());
        System.out.println("Returning events:");
        return "events";
    }

    /**
     * View a specific product by its id.
     *
     * @param eventId
     * @param model
     * @return
     */
    @RequestMapping("events/{eventId}")
    public String showEvent(@PathVariable Integer eventId, Model model) {
        model.addAttribute("event", eventService.getEventById(eventId));
        return "eventshow";
    }

    // Edit Event
    @RequestMapping("event/edit/{eventId}")
    public String edit(@PathVariable Integer eventId, Model model) {
        model.addAttribute("event", eventService.getEventById(eventId));
        return "eventform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("event/new")
    public String newEvent(Model model) {
        model.addAttribute("event", new Event());
        return "eventform";
    }

    /**
     * Save product to database.
     *
     * @param event
     * @return
     */
    @RequestMapping(value = "event", method = RequestMethod.POST)
    public String saveEvent(Event event) {
        eventService.saveEvent(event);
        //return "redirect:/event/" + event.getEventId();
        return "redirect:/events";
    }

    /**
     * Delete product by its id.
     *
     * @param eventid
     * @return
     */
    @RequestMapping("event/delete/{eventId}")
    public String delete(@PathVariable Integer eventId) {
        eventService.deleteEvent(eventId);
        return "redirect:/events";
    }

}
