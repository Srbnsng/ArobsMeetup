package com.arobs.ArobsMeetup.service.vote;

import com.arobs.ArobsMeetup.service.proposal.ProposalDTO;
import com.arobs.ArobsMeetup.service.proposal.VotedProposalDTO;
import com.arobs.ArobsMeetup.service.user.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface VoteService {

    void addVote(int user_id,int proposal_id) throws Exception;
    void removeVote(int user_id, int proposal_id) throws Exception;
    public Set<UserDTO> getProposalVoters(int proposal_id);
    public Set<ProposalDTO> getUserVotes(int user_id) ;
    public Set<VotedProposalDTO> getTopVotedProposalsList() ;
}
