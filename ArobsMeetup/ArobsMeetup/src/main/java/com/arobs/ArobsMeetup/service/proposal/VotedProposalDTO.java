package com.arobs.ArobsMeetup.service.proposal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class VotedProposalDTO {

    private int id;
    private String title;
    private int nrVotes;

    public VotedProposalDTO(int id, String title, int nrVotes) {
        this.id = id;
        this.title = title;
        this.nrVotes = nrVotes;
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

    public int getNrVotes() {
        return nrVotes;
    }

    public void setNrVotes(int nrVotes) {
        this.nrVotes = nrVotes;
    }
}
