package com.arobs.ArobsMeetup.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Entity(name="EventEntity")
@Table(name="event")
public class EventEntity {
    @Id @GeneratedValue
    @Column(name="id_event")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_proposer",referencedColumnName = "id")
    private UserEntity proposer_id;

    @Column(name="title" , length = 30)@NonNull
    private String title;

    @Column(name="edescription" , length = 100)@NonNull
    private String description;

    @Column(name="etype" , length = 30)@NonNull
    private String type;

    @Column(name="difficulty" , length = 30)@NonNull
    private String difficulty;

    @Column(name="elanguage" , length = 30)@NonNull
    private String language;

    @Column(name="duration") @NonNull
    private int duration;

    @Column(name = "max_attends") @NonNull
    private int max_attends;

    @Column(name = "date_time") @NonNull
    private Timestamp date_time;

    @Column(name = "room_name" , length = 30) @NonNull
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
}
