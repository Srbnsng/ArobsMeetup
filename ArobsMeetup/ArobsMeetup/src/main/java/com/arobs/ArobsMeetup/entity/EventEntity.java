package com.arobs.ArobsMeetup.domain;

import com.arobs.ArobsMeetup.domain.enums.Difficulty;
import com.arobs.ArobsMeetup.domain.enums.Type;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {

    private int id;
    private String title;
    private int proposer_id;
    private String description;
    private Type type;
    private Difficulty difficulty;
    private String language;
    private double duration;
    private int max_attends;
    private LocalDate date;
    private LocalTime time;
    private String room_name;


    public Event(int id, Proposal proposal, LocalDate date, LocalTime time, String room_name) {

        this.id = id;
        this.title = proposal.getTitle();
        this.proposer_id = proposal.getProposer_id();
        this.description = proposal.getDescription();
        this.type = proposal.getType();
        this.difficulty = proposal.getDifficulty();
        this.language = proposal.getLanguage();
        this.duration = proposal.getDuration();
        this.max_attends = proposal.getMax_attends();
        this.date = date;
        this.time = time;
        this.room_name = room_name;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getProposer_id() {
        return proposer_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getMax_attends() {
        return max_attends;
    }

    public void setMax_attends(int max_attends) {
        this.max_attends = max_attends;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }
}
