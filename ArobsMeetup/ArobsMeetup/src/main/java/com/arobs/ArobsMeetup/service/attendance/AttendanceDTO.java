package com.arobs.ArobsMeetup.service.attendance;

import com.arobs.ArobsMeetup.entity.EventEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;

public class AttendanceDTO {

    private EventEntity event;
    private UserEntity user;
    private int mark;
    private String note;


    public AttendanceDTO(EventEntity event, UserEntity user) {
        this.event = event;
        this.user = user;
        this.mark = 0;
        this.note = "";
    }

    public AttendanceDTO() {
    }

    public EventEntity getEvent() {
        return event;
    }

    public void setEvent(EventEntity event) {
        this.event = event;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
