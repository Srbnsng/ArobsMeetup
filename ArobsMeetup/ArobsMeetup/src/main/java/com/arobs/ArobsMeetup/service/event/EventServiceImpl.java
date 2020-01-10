package com.arobs.ArobsMeetup.service.event;

import com.arobs.ArobsMeetup.service.proposal.ProposalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
public class EventServiceImpl implements EventService{

    @Autowired
    private EventObject eventObject;

    @Override @Transactional
    public void createEvent(EventDTO eventDTO) {
        eventObject.createEvent(eventDTO);
    }

    @Override @Transactional
    public void deleteEvent(int id) {
        eventObject.removeEvent(id);
    }

    @Override @Transactional
    public void alterEvent(int id, EventDTO2 eventDTO) {
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
