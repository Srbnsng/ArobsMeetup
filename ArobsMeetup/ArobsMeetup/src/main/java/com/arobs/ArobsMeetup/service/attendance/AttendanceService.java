package com.arobs.ArobsMeetup.service.attendance;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttendanceService {

    void addAttendance(int user_id, int event_id);
    void removeAttendance(int id);
    List<AttendanceDTO> getAllAttendancesOfAnEvent(int event_id);
    List<AttendanceDTO> getAllAttendancesOfAnUser(int user_id);
    int getNrOfAttendancesOfAnEvent(int event_id);
    double getAverageMarkOfAnEvent(int event_id);
    void giveFeedback(int id, int mark,String note);

}
