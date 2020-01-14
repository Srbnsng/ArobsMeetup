package com.arobs.ArobsMeetup.service.attendance;

import com.arobs.ArobsMeetup.constants.AwardingConstants;
import com.arobs.ArobsMeetup.entity.AttendanceEntity;
import com.arobs.ArobsMeetup.entity.EventEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;
import com.arobs.ArobsMeetup.repository.AttendanceRepository;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.constants.RepositoryConstants;
import com.arobs.ArobsMeetup.repository.RepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AttendanceObject {

    @Autowired
    private RepositoryFactory factory;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private AttendanceMapper attendanceMapper;

    void addAttendance(int user_id, int event_id) throws Exception {
        IRepository user_repo = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        IRepository event_repo = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        UserEntity user =(UserEntity) user_repo.find(user_id);
        EventEntity event = (EventEntity) event_repo.find(event_id);
        validateAttend(user,event);
        if(verifyIfAttended(user_id,event_id)) {
            throw new Exception("This user is already attending this event! ");
        }
        if(verifyIfLimitReached(event_id)){
            throw new Exception("This event has already reached the maximum limit of attendances! ");
        }
        AttendanceEntity newAttendance = new AttendanceEntity(event, user);
        attendanceRepository.add(newAttendance);
    }

    public void validateAttend(UserEntity user, EventEntity event) throws Exception {
        if(user == null){
            throw new Exception("Invalid user id! ");
        }
        if(event == null){
            throw new Exception("Invalid event id! ");
        }
    }

    public boolean verifyIfAttended(int user_id, int event_id){
        List<AttendanceEntity> attendances = attendanceRepository.getAllAttendancesOfAnUser(user_id);
        for (AttendanceEntity attend:attendances){
            if(attend.getEvent().getId() == event_id){
                return true;
            }
        }
        return false;
    }

    public boolean verifyIfLimitReached(int eventId){
        IRepository event_repo = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        EventEntity event =(EventEntity) event_repo.find(eventId);
        return event.getMax_attends() < event.getAttendees().size();
    }

    public void removeAttendance(int id) throws Exception {
        AttendanceEntity attendanceEntity = attendanceRepository.find(id);
        if(attendanceEntity != null){
            attendanceRepository.remove(attendanceEntity);
        }
        else{
            throw new Exception("Attendance not found! ");
        }


    }
    List<AttendanceDTO> getAllAttendanceOfAnEvent(int event_id){
        List<AttendanceEntity> attendances = attendanceRepository.getAllAttendancesOfAnEvent(event_id);
        List<AttendanceDTO> attendancesDTO = new ArrayList<>();
        if(!attendances.isEmpty()){
            for(AttendanceEntity attendance : attendances){
                attendancesDTO.add(attendanceMapper.map(attendance, AttendanceDTO.class));
            }
        }
        return attendancesDTO;
    }
    List<AttendanceDTO> getAllAttendancesOfAnUser(int user_id){
        List<AttendanceEntity> attendances = attendanceRepository.getAllAttendancesOfAnUser(user_id);
        List<AttendanceDTO> attendancesDTO = new ArrayList<>();
        if(!attendances.isEmpty()){
            for(AttendanceEntity attendance : attendances){
                attendancesDTO.add(attendanceMapper.map(attendance, AttendanceDTO.class));
            }
        }
        return attendancesDTO;
    }

    int getNrOfAttendancesOfAnEvent(int event_id){
        return attendanceRepository.getAllAttendancesOfAnEvent(event_id).size();
    }

    double getAverageMarkOfAnEvent(int event_id){
        return attendanceRepository.getAverageMarkOfAnEvent(event_id);
    }

    void giveFeedback(int id, int mark,String note) throws Exception {
        IRepository user_repo = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        AttendanceEntity attendanceEntity = attendanceRepository.find(id);
        UserEntity user =(UserEntity)user_repo.find(attendanceEntity.getUser().getId());
        if(attendanceEntity != null ){
            if(!attendanceEntity.getEvent().getAvailability()){
                attendanceEntity.setMark(mark);
                attendanceEntity.setNote(note);
                user.setPoints(user.getPoints()+ AwardingConstants.FEEDBACK_POINTS);
                attendanceRepository.update(attendanceEntity);
                user_repo.update(user);
            }
            else{
                throw new Exception("Feedbacks are allowed after the event ends! ");
            }

        }
        else{
            throw new Exception("Attendance not found! ");
        }
    }
}
