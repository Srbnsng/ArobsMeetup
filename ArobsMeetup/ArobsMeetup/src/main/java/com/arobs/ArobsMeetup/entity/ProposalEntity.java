package com.arobs.ArobsMeetup.domain;

import com.arobs.ArobsMeetup.domain.enums.Difficulty;
import com.arobs.ArobsMeetup.domain.enums.Type;

public class Proposal {

    private int id;
    private String title;
    private int proposer_id;
    private String description;
    private Type type;
    private Difficulty difficulty;
    private String language;
    private double duration;
    private int max_attends;
    //private int votes;


    public Proposal(int id, String title, int proposer_id, String description, Type type, Difficulty difficulty, String language, double duration, int max_attends) {
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

    public Proposal(String title, int proposer_id, String description, Type type, Difficulty difficulty, String language, double duration, int max_attends) {
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

    public Type getType() {
        return type;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getLanguage() {
        return language;
    }

    public double getDuration() {
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

    public void setType(Type type) {
        this.type = type;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setMax_attends(int max_attends) {
        this.max_attends = max_attends;
    }
}
