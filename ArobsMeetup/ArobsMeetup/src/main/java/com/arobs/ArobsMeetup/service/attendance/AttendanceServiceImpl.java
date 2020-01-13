package com.arobs.ArobsMeetup.service.attendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    AttendanceObject attendanceObject;

    @Override @Transactional
    public void addAttendance(int user_id, int event_id) throws Exception {
        attendanceObject.addAttendance(user_id,event_id);
    }

    @Override @Transactional
    public void removeAttendance(int id) throws Exception {
        attendanceObject.removeAttendance(id);
    }

    @Override @Transactional
    public List<AttendanceDTO> getAllAttendancesOfAnEvent(int event_id) {
        return attendanceObject.getAllAttendanceOfAnEvent(event_id);
    }

    @Override @Transactional
    public List<AttendanceDTO> getAllAttendancesOfAnUser(int user_id) {
        return attendanceObject.getAllAttendancesOfAnUser(user_id);
    }

    @Override @Transactional
    public int getNrOfAttendancesOfAnEvent(int event_id) {
        return attendanceObject.getNrOfAttendancesOfAnEvent(event_id);
    }

    @Override @Transactional
    public double getAverageMarkOfAnEvent(int event_id) {
        return attendanceObject.getAverageMarkOfAnEvent(event_id);
    }

    @Override @Transactional
    public void giveFeedback(int id, int mark, String note) throws Exception {
        attendanceObject.giveFeedback(id,mark,note);
    }
}
