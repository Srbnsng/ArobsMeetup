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

    @Override
    public void deleteEvent(int id) {

    }

    @Override
    public void alterEvent(int id, EventDTO eventDTO) {

    }

    @Override @Transactional
    public EventDTO2 findEvent(int id) {
        return eventObject.findEvent(id);
    }

    @Override
    public List<EventDTO2> findAllEvents() {
        return null;
    }
}
