package com.arobs.ArobsMeetup.service;

import com.arobs.ArobsMeetup.domain.Proposal;
import com.arobs.ArobsMeetup.domain.Vote;
import com.arobs.ArobsMeetup.domain.enums.Difficulty;
import com.arobs.ArobsMeetup.domain.enums.Type;
import com.arobs.ArobsMeetup.repository.ProposalRepository;
import com.arobs.ArobsMeetup.repository.ProposalVotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class UserService implements IUserService {

    @Autowired
    private ProposalRepository proposalRepository;
    @Autowired
    private ProposalVotesRepository proposalVotesRepository;


    public UserService(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }


    @Override
    public Proposal createProposal(String title, int proposer_id, String desc, Type type,
                                         Difficulty diff, String lang, double duration, int maxattends) throws SQLException {
        Proposal newProposal = new Proposal(title,proposer_id,desc,type,diff,lang,duration,maxattends);

        int i = proposalRepository.add(newProposal);
        if(i > 0)
            return newProposal;
        else
            return null;
    }

    @Override
    public void voteToggle(int proposal_id, int user_id) throws SQLException {

        Proposal p = proposalRepository.find(proposal_id);
        List<Vote> proposalVotes = proposalVotesRepository.findAll();
        boolean removed = false;
        for(Vote v : proposalVotes){
            if(removed)
                break;
            if(v.getUser_id() == user_id){
                proposalVotesRepository.remove(v);
                removed=true;
            }
        }
        if(!removed)
            proposalVotes.add(new Vote(proposal_id,user_id));
    }


}
