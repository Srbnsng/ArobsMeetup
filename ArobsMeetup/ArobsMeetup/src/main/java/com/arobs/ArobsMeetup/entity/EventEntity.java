package com.arobs.ArobsMeetup.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="EventEntity")
@Table(name="event")
public class EventEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_event")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_proposer",referencedColumnName = "id")
    private UserEntity proposer;

    @Column(name="title" , length = 30)
    private String title;

    @Column(name="edescription" , length = 100)
    private String description;

    @Column(name="etype" , length = 30)
    private String type;

    @Column(name="difficulty" , length = 30)
    private String difficulty;

    @Column(name="elanguage" , length = 30)
    private String language;

    @Column(name="duration")
    private int duration;

    @Column(name = "max_attends")
    private int max_attends;

    @Column(name = "event_date")
    private Date event_date;

    @Column(name = "room_name" , length = 30)
    private String room_name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true, mappedBy = "event")
    private Set<AttendanceEntity> attendees = new HashSet<>();

    public EventEntity(ProposalEntity proposalEntity,Date event_date, String room_name) {

        this.title = proposalEntity.getTitle();
        this.proposer = proposalEntity.getProposer();
        this.description = proposalEntity.getDescription();
        this.type = proposalEntity.getType();
        this.difficulty = proposalEntity.getDifficulty();
        this.language = proposalEntity.getLanguage();
        this.duration = proposalEntity.getDuration();
        this.max_attends = proposalEntity.getMax_attends();
        this.event_date = event_date;
        this.room_name = room_name;
    }

    public EventEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getProposer_id() {
        return proposer;
    }

    public void setProposer_id(UserEntity proposer_id) {
        this.proposer = proposer_id;
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

    public UserEntity getProposer() {
        return proposer;
    }

    public void setProposer(UserEntity proposer) {
        this.proposer = proposer;
    }

    public Set<AttendanceEntity> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<AttendanceEntity> attendees) {
        this.attendees = attendees;
    }
}
