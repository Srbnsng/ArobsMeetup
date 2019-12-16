package com.arobs.ArobsMeetup.service;

import com.arobs.ArobsMeetup.entity.EventEntity;
import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.entity.VoteEntity;
import com.arobs.ArobsMeetup.service.dto.ProposalDTO;
import com.arobs.ArobsMeetup.repository.ProposalRepository;
import com.arobs.ArobsMeetup.repository.ProposalVotesRepository;
import com.arobs.ArobsMeetup.service.dto.VoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class UserObject {

    @Autowired
    private ProposalRepository proposalRepository;
    @Autowired
    private ProposalVotesRepository proposalVotesRepository;
    @Autowired
    private ProposalMapper proposalMapper;


    public UserObject(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }


    public boolean createProposal(ProposalDTO proposalDTO) throws SQLException {

        if(proposalDTO!=null){
            ProposalEntity newProposalEntity= proposalMapper.map(proposalDTO,ProposalEntity.class);
            int i = proposalRepository.add(newProposalEntity);
            if(i > 0)
                return true;
        }
        return false;

    }

    public void voteToggle(VoteDTO voteDTO) throws SQLException {

        ProposalEntity p = proposalRepository.find(voteDTO.getProposal_id());
        List<VoteEntity> proposalVoteEntities = proposalVotesRepository.findAll();
        boolean removed = false;
        for(VoteEntity v : proposalVoteEntities){
            if(removed)
                break;
            if(v.getUser_id() == voteDTO.getUser_id()){
                proposalVotesRepository.remove(v);
                removed=true;
            }
        }
        if(!removed)
            //mapper - VoteDTO -> VoteEntity
            proposalVoteEntities.add(new VoteEntity(voteDTO.getProposal_id(),voteDTO.getUser_id()));
    }

    public void acceptProposal(ProposalDTO proposalDTO) throws SQLException{

        //mapper -> ProposalDto -> ProposalEntity
       // EventEntity event = new EventEntity();
    }

}
