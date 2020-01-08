package com.arobs.ArobsMeetup.service.vote;

import com.arobs.ArobsMeetup.service.proposal.ProposalDTO;
import com.arobs.ArobsMeetup.service.proposal.VotedProposalDTO;
import com.arobs.ArobsMeetup.service.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
public class VoteServiceImpl implements VoteService{

    @Autowired
    private VoteObject voteObject;


    @Override @Transactional
    public void addVote(int user_id, int proposal_id) {
        voteObject.addVote(user_id,proposal_id);
    }

    @Override @Transactional
    public void removeVote(int user_id, int proposal_id) {
        voteObject.removeVote(user_id,proposal_id);
    }

    @Override @Transactional
    public Set<UserDTO> getProposalVoters(int proposal_id) {
        return voteObject.getProposalVoters(proposal_id);
    }

    @Override @Transactional
    public Set<ProposalDTO> getUserVotes(int user_id) {
        return voteObject.getUserVotes(user_id);
    }

    @Override @Transactional
    public Set<VotedProposalDTO> getTopVotedProposalsList(){
        return voteObject.getTopVotedProposalList();
    }
}
