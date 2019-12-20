package com.arobs.ArobsMeetup.service;

public class VoteDTO {

    private int proposal_id;
    private int user_id;

    public int getProposal_id() {
        return proposal_id;
    }

    public void setProposal_id(int proposal_id) {
        this.proposal_id = proposal_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public VoteDTO(int proposal_id, int user_id) {
        this.proposal_id = proposal_id;
        this.user_id = user_id;
    }
}
