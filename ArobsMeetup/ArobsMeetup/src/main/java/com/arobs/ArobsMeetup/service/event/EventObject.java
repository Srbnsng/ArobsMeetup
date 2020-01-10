package com.arobs.ArobsMeetup.service.event;

import com.arobs.ArobsMeetup.entity.EventEntity;
import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.repository.RepositoryConstants;
import com.arobs.ArobsMeetup.repository.RepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventObject {

    @Autowired
    private RepositoryFactory factory;
    @Autowired
    private EventMapper eventMapper;

    public void createEvent(EventDTO eventDTO){

        IRepository proposal_repo = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        IRepository event_repo = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        ProposalEntity proposalEntity = (ProposalEntity)proposal_repo.find(eventDTO.getProposal_id());
        if(proposalEntity!= null){
            EventEntity eventEntity = new EventEntity(proposalEntity,eventDTO.getEvent_date(),eventDTO.getRoom_name());
            event_repo.add(eventEntity);
            proposal_repo.remove(proposalEntity);
        }
        else{
            // This will be not here but for the moment is just as an example
            System.out.println("Proposal not found!");
        }
    }

    public EventDTO2 findEvent(int id){

        IRepository repository = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        EventEntity eventEntity = (EventEntity)repository.find(id);
        if(eventEntity!=null)
            return eventMapper.map(eventEntity,EventDTO2.class);
        else{
            // This will be not here but for the moment is just as an example of error
            System.out.println("Event not found!");
        }

        return null;
    }

    public List<EventDTO2>findAllEvents(){
        IRepository repository = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        List<EventEntity> events = repository.findAll();
        if(events !=null)
            return eventMapper.mapAsList(events,EventDTO2.class);
        else{
            // This will be not here but for the moment is just as an example of error
            System.out.println("No events !");
        }

        return null;
    }

    public void removeEvent(int id){
        IRepository repository = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        EventEntity eventEntity = (EventEntity)repository.find(id);
        if(eventEntity != null)
            repository.remove(eventEntity);
        else{
            // This will be not here but for the moment is just as an example of error
            System.out.println("Event not found!");
        }
    }

    public void alterEvent(int id,EventDTO2 eventDTO){
        IRepository repository = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        EventEntity eventEntity = (EventEntity)repository.find(id);
        if(eventEntity != null ){
            eventEntity.setTitle(eventDTO.getTitle());
            eventEntity.setDescription(eventDTO.getDescription());
            eventEntity.setDifficulty(eventDTO.getDifficulty());
            eventEntity.setDuration(eventDTO.getDuration());
            eventEntity.setEvent_date(eventDTO.getEvent_date());
            eventEntity.setLanguage(eventDTO.getLanguage());
            eventEntity.setMax_attends(eventDTO.getMax_attends());
            eventEntity.setProposer(eventDTO.getProposer());
            eventEntity.setRoom_name(eventDTO.getRoom_name());
            eventEntity.setType(eventDTO.getType());
            repository.update(eventEntity);
        }
        else{
            // This will be not here but for the moment is just as an example of error
            System.out.println("Event not found!");
        }

    }
}
