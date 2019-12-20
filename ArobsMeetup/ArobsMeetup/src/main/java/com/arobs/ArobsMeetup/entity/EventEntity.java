package com.arobs.ArobsMeetup.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name="EventEntity")
@Table(name="event")
public class EventEntity {
    @Id @GeneratedValue
    @Column(name="id_event")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_proposer",referencedColumnName = "id")
    private UserEntity proposer_id;

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

    @Column(name = "date_time")
    private Timestamp date_time;

    @Column(name = "room_name" , length = 30)
    private String room_name;

    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true, mappedBy = "event")
    List<AttendanceEntity> attendances = new ArrayList<>();

    public EventEntity(int id, ProposalEntity proposalEntity,Timestamp date_time, String room_name) {

        this.id = id;
        this.title = proposalEntity.getTitle();
        this.proposer_id = proposalEntity.getProposer();
        this.description = proposalEntity.getDescription();
        this.type = proposalEntity.getType();
        this.difficulty = proposalEntity.getDifficulty();
        this.language = proposalEntity.getLanguage();
        this.duration = proposalEntity.getDuration();
        this.max_attends = proposalEntity.getMax_attends();
        this.date_time = date_time;
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

    public Timestamp getDate_time() {
        return date_time;
    }

    public void setDate_time(Timestamp date_time) {
        this.date_time = date_time;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public List<AttendanceEntity> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<AttendanceEntity> attendances) {
        this.attendances = attendances;
    }
}
