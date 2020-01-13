package com.arobs.ArobsMeetup.controller;

import com.arobs.ArobsMeetup.service.attendance.AttendanceDTO;
import com.arobs.ArobsMeetup.service.attendance.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendances")
public class AttendanceController {

    @Autowired
    AttendanceService attendanceService;

    @PostMapping(path = "/attendEvent/user{id_user}/event{id_event}")
    public ResponseEntity<String> attendEvent(@PathVariable int id_user, @PathVariable int id_event){
        try {
            attendanceService.addAttendance(id_user,id_event);
            return ResponseEntity.ok("An attend was commit! ");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping(path = "/getEventAttends/{id_event}")
    public ResponseEntity<List<AttendanceDTO>> getEventAttends(@PathVariable int id_event){
        return ResponseEntity.ok(attendanceService.getAllAttendancesOfAnEvent(id_event));
    }

    @GetMapping(path = "/getUserAttends/{id_user}")
    public ResponseEntity<List<AttendanceDTO>> getUserAttends(@PathVariable int id_user){
        return ResponseEntity.ok(attendanceService.getAllAttendancesOfAnUser(id_user));
    }

    @GetMapping(path = "/getEventAverageMark/{id_event}")
    public ResponseEntity<Double> getEventAverageMark(@PathVariable int id_event){
        return ResponseEntity.ok(attendanceService.getAverageMarkOfAnEvent(id_event));
    }

    @GetMapping(path = "/getEventAttendsNr/{id_event}")
    public ResponseEntity<Integer> getEventAttendsNr(@PathVariable int id_event){
        return ResponseEntity.ok(attendanceService.getNrOfAttendancesOfAnEvent(id_event));
    }

    @PostMapping(path = "/giveFeedback/{id}/{mark}/{note}")
    public ResponseEntity<String> attendEvent(@PathVariable int id , @PathVariable int mark , @PathVariable String note){
        try {
            attendanceService.giveFeedback(id,mark,note);
            return ResponseEntity.ok("Feedback submitted !");
        } catch (Exception e) {
           return ResponseEntity.ok(e.getMessage());
        }

    }

}
