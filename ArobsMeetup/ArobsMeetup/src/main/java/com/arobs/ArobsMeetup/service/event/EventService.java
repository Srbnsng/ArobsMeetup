package com.arobs.ArobsMeetup.service.event;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public interface EventService {

    void createEvent(EventDTO eventDTO);
    void deleteEvent(int id);
    void alterEvent(int id, EventDTO2 eventDTO);
    EventDTO2 findEvent(int id);
    List<EventDTO2> findAllEvents();
}
