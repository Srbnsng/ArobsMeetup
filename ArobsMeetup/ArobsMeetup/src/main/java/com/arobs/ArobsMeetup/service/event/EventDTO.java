package com.arobs.ArobsMeetup.service.event;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.tomcat.jni.Local;

import java.sql.Date;
import java.sql.Time;


@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDTO {

    private int proposal_id;
    private Date event_date;
    private String room_name;

    public EventDTO() {
    }

    public EventDTO(int proposal_id, Date event_date, String room_name) {
        this.proposal_id = proposal_id;
        this.event_date = event_date;
        this.room_name = room_name;
    }



    public int getProposal_id() {
        return proposal_id;
    }

    public void setProposal_id(int proposal_id) {
        this.proposal_id = proposal_id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public Date getEvent_date() {
        return event_date;
    }

    public void setEvent_date(Date event_date) {
        this.event_date = event_date;
    }

}
