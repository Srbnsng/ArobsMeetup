package com.arobs.ArobsMeetup.service.event;

import com.arobs.ArobsMeetup.constants.AwardingConstants;
import com.arobs.ArobsMeetup.entity.AttendanceEntity;
import com.arobs.ArobsMeetup.entity.EventEntity;
import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.constants.RepositoryConstants;
import com.arobs.ArobsMeetup.repository.RepositoryFactory;
import com.arobs.ArobsMeetup.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Component @EnableAsync
public class EventObject {

    @Autowired
    private RepositoryFactory factory;
    @Autowired
    private EventMapper eventMapper;
    @Autowired
    private VoteRepository voteRepository;

    public void createEvent(EventDTO eventDTO) throws Exception {

        IRepository proposal_repo = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        IRepository event_repo = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        ProposalEntity proposalEntity = (ProposalEntity) proposal_repo.find(eventDTO.getProposal_id());
        if (proposalEntity != null) {
            if (isValidFormat(eventDTO.getEvent_date())) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                dateFormat.setLenient(false);
                dateFormat.parse(eventDTO.getEvent_date().trim());
                EventEntity eventEntity = new EventEntity(proposalEntity, eventDTO.getEvent_date(), eventDTO.getRoom_name());
                Set<UserEntity> voters = proposalEntity.getUserVotes();
                for(UserEntity user : voters){
                    voteRepository.remove(user.getId(),proposalEntity.getId());
                }
                event_repo.add(eventEntity);
                proposal_repo.remove(proposalEntity);
            } else {
                throw new Exception("Datetime format is invalid! ");
            }
        } else {
            throw new Exception("Proposal not found! ");
        }
    }

    public EventDTO2 findEvent(int id) {

        IRepository repository = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        EventEntity eventEntity = (EventEntity) repository.find(id);
        if (eventEntity != null)
            return eventMapper.map(eventEntity, EventDTO2.class);
        else {
            return null;
        }
    }

    public List<EventDTO2> findAllEvents() {
        IRepository repository = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        List<EventEntity> events = repository.findAll();
        if (events != null)
            return eventMapper.mapAsList(events, EventDTO2.class);

        return null;
    }

    public void removeEvent(int id) throws Exception {
        IRepository repository = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        EventEntity eventEntity = (EventEntity) repository.find(id);
        if (eventEntity != null)
            repository.remove(eventEntity);
        else {
            throw new Exception("Event id not found! ");
        }
    }

    public void alterEvent(int id, EventDTO2 eventDTO) throws Exception {
        IRepository repository = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        EventEntity eventEntity = (EventEntity) repository.find(id);
        if (eventEntity != null) {
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
        } else {
            throw new Exception("Event id not found! ");
        }

    }

    private boolean isValidFormat(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    @Transactional
    @Scheduled(fixedRate = 5*60*1000)
    @Async
    public void verifyEventDate() {
        IRepository repository = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<EventEntity> events = repository.findAll();
        for (EventEntity event : events) {
            try {
                if (dateFormat.parse(event.getEvent_date()).before(new Date()) && event.getAvailability()) {
                    event.setAvailability(false);
                    repository.update(event);
                    awardUsers(event);
                    awardOrganiser(event);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void awardOrganiser(EventEntity event) {

        UserEntity organiser = event.getProposer();
        System.out.println(organiser.getFull_name()+ " = " + organiser.getPoints());
        IRepository user_repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        if(event.getDifficulty().equals("Easy")){
            organiser.setPoints(organiser.getPoints()+AwardingConstants.EASY_LEVEL_POINTS);
        }
        if(event.getDifficulty().equals("Medium")){
            organiser.setPoints(organiser.getPoints()+AwardingConstants.MEDIUM_LEVEL_POINTS);
        }
        if(event.getDifficulty().equals("High")){
            organiser.setPoints(organiser.getPoints()+AwardingConstants.HIGH_LEVEL_POINTS);
        }
        user_repository.update(organiser);

        organiser = (UserEntity) user_repository.find(organiser.getId());
        System.out.println(organiser.getFull_name()+ " = " + organiser.getPoints());
    }

    public void awardUsers(EventEntity event){

        IRepository user_repository = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        Set<AttendanceEntity> attendanceEntities = event.getAttendees();
        for(AttendanceEntity attendance : attendanceEntities){
            UserEntity user = attendance.getUser();
            user.setPoints(user.getPoints() + AwardingConstants.ATTENDER_POINTS);
            user_repository.update(user);
        }
    }
}
