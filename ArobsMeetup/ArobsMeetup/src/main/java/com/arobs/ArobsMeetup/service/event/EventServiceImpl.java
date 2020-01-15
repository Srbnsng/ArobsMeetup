package com.arobs.ArobsMeetup.service.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
public class EventServiceImpl implements EventService{

    @Autowired
    private EventObject eventObject;

    @Override @Transactional
    public void createEvent(EventDTO eventDTO) throws Exception {
        eventObject.createEvent(eventDTO);
    }

    @Override @Transactional
    public void deleteEvent(int id) throws Exception {
        eventObject.removeEvent(id);
    }

    @Override @Transactional
    public void alterEvent(int id, EventDTO2 eventDTO) throws Exception {
        eventObject.alterEvent(id,eventDTO);
    }

    @Override @Transactional
    public EventDTO2 findEvent(int id) {
        return eventObject.findEvent(id);
    }

    @Override @Transactional
    public List<EventDTO2> findAllEvents() {
        return eventObject.findAllEvents();
    }
}
