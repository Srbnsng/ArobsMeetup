package com.arobs.ArobsMeetup.service.vote;


import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.repository.RepositoryConstants;
import com.arobs.ArobsMeetup.repository.RepositoryFactory;
import com.arobs.ArobsMeetup.repository.VoteRepository;
import com.arobs.ArobsMeetup.service.proposal.ProposalDTO;
import com.arobs.ArobsMeetup.service.proposal.ProposalMapper;
import com.arobs.ArobsMeetup.service.proposal.VotedProposalDTO;
import com.arobs.ArobsMeetup.service.user.UserDTO;
import com.arobs.ArobsMeetup.service.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class VoteObject {

    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private ProposalMapper proposalMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RepositoryFactory factory;

    public void addVote(int user_id, int proposal_id) throws Exception {
        IRepository user_repo = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        IRepository proposal_repo = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        UserEntity user = (UserEntity) user_repo.find(user_id);
        ProposalEntity proposal = (ProposalEntity) proposal_repo.find(proposal_id);
        validateVote(user, proposal);
        if(verifyIfVoted(user.getId(),proposal.getId()))
            throw new Exception("This user already voted this proposal !");
        user_repo.update(user);
        voteRepository.add(user_id, proposal_id);
    }

    public void validateVote(UserEntity user, ProposalEntity proposal) throws Exception{
        if(user == null)
            throw new Exception("User not found! ");
        if(proposal == null)
            throw new Exception("Proposal not found! ");
    }

    public boolean verifyIfVoted(int user_id, int proposal_id){
        Set<ProposalEntity> votedProposals = voteRepository.getUserVotes(user_id);
        for (ProposalEntity p: votedProposals) {
            if (p.getId() == proposal_id){
                return true;
            }
        }
        return false;
    }

    public void removeVote(int user_id, int proposal_id) throws Exception{
        IRepository user_repo = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        IRepository proposal_repo = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        UserEntity user =(UserEntity) user_repo.find(user_id);
        ProposalEntity proposal = (ProposalEntity) proposal_repo.find(proposal_id);
        validateVote(user,proposal);
        voteRepository.remove(user_id,proposal_id);
    }

    public Set<ProposalDTO> getUserVotes(int user_id){
        Set<ProposalEntity> votedProposals = voteRepository.getUserVotes(user_id);
        Set<ProposalDTO> votedProposalsDTO = new HashSet<>();
        if(!votedProposals.isEmpty()){
            for(ProposalEntity proposal : votedProposals){
                votedProposalsDTO.add(proposalMapper.map(proposal, ProposalDTO.class));
            }
        }
        return votedProposalsDTO;
    }

    public Set<UserDTO> getProposalVoters(int proposal_id){
        Set<UserEntity> voters = voteRepository.getProposalVoters(proposal_id);
        Set<UserDTO> votersDTO = new HashSet<>();
        if(!voters.isEmpty()){
            for(UserEntity user : voters){
                votersDTO.add(userMapper.map(user, UserDTO.class));
            }
        }
        return votersDTO;

    }

    public Set<VotedProposalDTO> getTopVotedProposalList(){

        List<VotedProposalDTO> topList= new ArrayList<>();
        List<Object[]> objectList = voteRepository.getTopListOfProposals();
        for(Object[] obj : objectList){
            VotedProposalDTO votedProposalDTO = new VotedProposalDTO((Integer)obj[0],(String)obj[1],(Integer)obj[2]);
            topList.add(votedProposalDTO);
        }
        return topList.stream().collect(Collectors.toSet());
    }
}
