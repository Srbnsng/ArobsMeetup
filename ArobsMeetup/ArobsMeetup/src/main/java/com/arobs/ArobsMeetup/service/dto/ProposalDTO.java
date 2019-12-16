package com.arobs.ArobsMeetup.service.dto;

import com.arobs.ArobsMeetup.service.dto.enums.Difficulty;
import com.arobs.ArobsMeetup.service.dto.enums.Type;

public class ProposalDTO {

    private int id;
    private String title;
    private int proposer_id;
    private String description;
    private Type type;
    private Difficulty difficulty;
    private String language;
    private int duration;
    private int max_attends;


    public ProposalDTO(String title, int proposer_id, String description, Type type, Difficulty difficulty, String language, int duration, int max_attends) {
        this.title = title;
        this.proposer_id = proposer_id;
        this.description = description;
        this.type = type;
        this.difficulty = difficulty;
        this.language = language;
        this.duration = duration;
        this.max_attends = max_attends;
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

    public int getProposer_id() {
        return proposer_id;
    }

    public void setProposer_id(int proposer_id) {
        this.proposer_id = proposer_id;
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
}
