package com.arobs.ArobsMeetup.entity;

import javax.persistence.*;

@Entity
@Table(name="Proposal")
public class ProposalEntity {
    @Id @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="proposer_id")
    private int proposer_id;
    @Column(name="description")
    private String description;
    @Column(name="ptype")
    private String type;
    @Column(name="difficulty")
    private String difficulty;
    @Column(name="planguage")
    private String language;
    @Column(name="duration")
    private int duration;
    @Column(name = "max_attends")
    private int max_attends;
    //private int votes;


    public ProposalEntity(int id, String title, int proposer_id, String description, String type, String difficulty, String language, int duration, int max_attends) {
        this.id = id;
        this.title = title;
        this.proposer_id = proposer_id;
        this.description = description;
        this.type = type;
        this.difficulty = difficulty;
        this.language = language;
        this.duration = duration;
        this.max_attends = max_attends;
        //this.votes = votes;
    }

    public ProposalEntity(String title, int proposer_id, String description, String type, String difficulty, String language,int duration, int max_attends) {
        this.title = title;
        this.proposer_id = proposer_id;
        this.description = description;
        this.type = type;
        this.difficulty = difficulty;
        this.language = language;
        this.duration = duration;
        this.max_attends = max_attends;
        //this.votes = 0;
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

    public String getType() {
        return type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getLanguage() {
        return language;
    }

    public int getDuration() {
        return duration;
    }

    public int getMax_attends() {
        return max_attends;
    }

//    public int getVotes() {
//        return votes;
//    }
//
//    public void setVotes(int votes) {
//        this.votes = votes;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setMax_attends(int max_attends) {
        this.max_attends = max_attends;
    }
}
