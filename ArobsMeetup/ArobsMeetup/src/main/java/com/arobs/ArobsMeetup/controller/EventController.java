package com.arobs.ArobsMeetup.controller;

import com.arobs.ArobsMeetup.service.event.EventDTO;
import com.arobs.ArobsMeetup.service.event.EventDTO2;
import com.arobs.ArobsMeetup.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<EventDTO2> findEventById(@PathVariable int id){
        return ResponseEntity.ok(eventService.findEvent(id));
    }
    @GetMapping(path = "/")
    public ResponseEntity<List<EventDTO2>> findAllEvents(){
        return ResponseEntity.ok(eventService.findAllEvents());
    }

    @PostMapping(path = "/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody EventDTO eventDTO){
        try {
            eventService.createEvent(eventDTO);
            return ResponseEntity.ok("New Event created! ");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }

    }

    @DeleteMapping(path = "/deleteEvent/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable int id){
        try {
            eventService.deleteEvent(id);
            return ResponseEntity.ok("Event with id " + id + " deleted! ");
        } catch (Exception e) {
           return ResponseEntity.ok(e.getMessage());
        }

    }

    @PutMapping(path = "/updateEvent/{id}")
    public ResponseEntity<String> updateEvent(@PathVariable int id, @RequestBody EventDTO2 eventDTO){
        try {
            eventService.alterEvent(id,eventDTO);
            return ResponseEntity.ok("Event with id " + id + " updated! ");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }

    }
}
