package com.arobs.ArobsMeetup.service.event;

import com.arobs.ArobsMeetup.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDTO2 {

    private int id;
    private UserEntity proposer_id;
    private String title;
    private String description;
    private String type;
    private String difficulty;
    private String language;
    private int duration;
    private int max_attends;
    private Date event_date;
    private String room_name;

    public EventDTO2(int id, UserEntity proposer_id, String title, String description, String type, String difficulty, String language, int duration, int max_attends, Date event_date, String room_name) {
        this.id = id;
        this.proposer_id = proposer_id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.difficulty = difficulty;
        this.language = language;
        this.duration = duration;
        this.max_attends = max_attends;
        this.event_date = event_date;
        this.room_name = room_name;
    }

    public EventDTO2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getProposer_id() {
        return proposer_id;
    }

    public void setProposer_id(UserEntity proposer_id) {
        this.proposer_id = proposer_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMax_attends() {
        return max_attends;
    }

    public void setMax_attends(int max_attends) {
        this.max_attends = max_attends;
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
