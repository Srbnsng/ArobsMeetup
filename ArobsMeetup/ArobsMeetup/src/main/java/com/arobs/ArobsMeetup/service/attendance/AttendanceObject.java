package com.arobs.ArobsMeetup.service.attendance;

import com.arobs.ArobsMeetup.entity.AttendanceEntity;
import com.arobs.ArobsMeetup.entity.EventEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;
import com.arobs.ArobsMeetup.repository.AttendanceRepository;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.repository.RepositoryConstants;
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

    void addAttendance(int user_id, int event_id){
        IRepository user_repo = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        IRepository event_repo = factory.createRepository(RepositoryConstants.EVENT_REPOSITORY_TYPE);
        UserEntity user =(UserEntity) user_repo.find(user_id);
        EventEntity event = (EventEntity) event_repo.find(event_id);
        if(event != null){
            if(user != null){
                if(event.getAttendees().size() < event.getMax_attends()){
                    AttendanceEntity newAttendance = new AttendanceEntity(event, user);
                    attendanceRepository.add(newAttendance);
                }
                else{
                    // This will be not here but for the moment is just as an example of error
                    System.out.println("Maximum attendances limit reached for this event! ");
                }

            }
            else{
                // This will be not here but for the moment is just as an example of error
                System.out.println("User not found!");
            }
        }
        else{
            // This will be not here but for the moment is just as an example of error
            System.out.println("Event not found!");
        }
    }
    void removeAttendance(int id){
        AttendanceEntity attendanceEntity = attendanceRepository.find(id);
        if(attendanceEntity != null){
            attendanceRepository.remove(attendanceEntity);
        }
        else{
            // This will be not here but for the moment is just as an example of error
            System.out.println("Attendance not found!");
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

    void giveFeedback(int id, int mark,String note){
        AttendanceEntity attendanceEntity = attendanceRepository.find(id);
        if(attendanceEntity != null){
            attendanceEntity.setMark(mark);
            attendanceEntity.setNote(note);
            attendanceRepository.update(attendanceEntity);
        }
        else{
            // This will be not here but for the moment is just as an example of error
            System.out.println("Attendance not found!");
        }
    }
}
