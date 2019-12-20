package com.arobs.ArobsMeetup.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="proposal")
public class ProposalEntity {
    @Id @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="title" , length = 30)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proposer_id" , referencedColumnName = "id")
    private UserEntity proposer;

    @Column(name="description" , length = 100)
    private String description;

    @Column(name="ptype" , length = 30)
    private String type;

    @Column(name="difficulty")
    private String difficulty;

    @Column(name="planguage" , length = 30)
    private String language;

    @Column(name="duration")
    private int duration;

    @Column(name = "max_attends")
    private int max_attends;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "proposal")
    List<VoteEntity> votes = new ArrayList<>();


    public ProposalEntity(int id, String title, UserEntity proposer, String description, String type, String difficulty, String language, int duration, int max_attends) {
        this.id = id;
        this.title = title;
        this.proposer = proposer;
        this.description = description;
        this.type = type;
        this.difficulty = difficulty;
        this.language = language;
        this.duration = duration;
        this.max_attends = max_attends;
        //this.votes = votes;
    }

    public ProposalEntity(String title, UserEntity proposer, String description, String type, String difficulty, String language,int duration, int max_attends) {
        this.title = title;
        this.proposer = proposer;
        this.description = description;
        this.type = type;
        this.difficulty = difficulty;
        this.language = language;
        this.duration = duration;
        this.max_attends = max_attends;
        //this.votes = 0;
    }

    public ProposalEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserEntity getProposer() {
        return proposer;
    }

    public void setProposer(UserEntity proposer) {
        this.proposer = proposer;
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

    public List<VoteEntity> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteEntity> votes) {
        this.votes = votes;
    }
}
