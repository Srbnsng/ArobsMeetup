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

    @PostMapping(path = "/create")
    public String createEvent(@RequestBody EventDTO eventDTO){
        eventService.createEvent(eventDTO);
        return "HTTP Create method called!";
    }
}
