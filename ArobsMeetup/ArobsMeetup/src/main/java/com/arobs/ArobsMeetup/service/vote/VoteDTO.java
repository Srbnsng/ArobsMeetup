package com.arobs.ArobsMeetup.service.vote;

import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoteDTO {

    private UserEntity user;
    private ProposalEntity proposal;

    public VoteDTO(UserEntity user, ProposalEntity proposal) {
        this.user = user;
        this.proposal = proposal;
    }

    public VoteDTO() {
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProposalEntity getProposal() {
        return proposal;
    }

    public void setProposal(ProposalEntity proposal) {
        this.proposal = proposal;
    }
}
