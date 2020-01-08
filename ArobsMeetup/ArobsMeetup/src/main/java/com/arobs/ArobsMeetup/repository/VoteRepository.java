package com.arobs.ArobsMeetup.repository;

import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class VoteRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(VoteRepository.class);

    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProposalRepository proposalRepository;


    public void add(int user_id, int proposal_id) {
        LOGGER.info(" ==> VoteRepository = add() ");
        UserEntity user = userRepository.find(user_id);
        ProposalEntity proposal = proposalRepository.find(proposal_id);
        user.getVotedProposals().add(proposal);
        proposal.getUserVotes().add(user);
    }

    public void remove(int user_id, int proposal_id) {
        LOGGER.info("  ==> VoteRepository = remove() ");
        UserEntity user = userRepository.find(user_id);
        ProposalEntity proposal = proposalRepository.find(proposal_id);
        user.getVotedProposals().remove(proposal);
        proposal.getUserVotes().remove(user);
    }

    public Set<ProposalEntity> getUserVotes(int user_id){
        Session session = sessionFactory.getCurrentSession();
        List<ProposalEntity> votedProposals = session.createNativeQuery("SELECT * FROM " +
                "proposal INNER JOIN vote ON vote.id_proposal = proposal.id WHERE vote.id_user =?")
                .setParameter(1, user_id).addEntity(ProposalEntity.class).list();
        return votedProposals.stream().collect(Collectors.toSet());
    }


    public Set<UserEntity> getProposalVoters(int proposal_id){
        Session session = sessionFactory.getCurrentSession();
        List<UserEntity> proposalVotes = session.createNativeQuery("SELECT * FROM " +
                "`user` INNER JOIN vote ON vote.id_user = `user`.id WHERE vote.id_proposal =?")
                .setParameter(1, proposal_id).addEntity(UserEntity.class).list();
        return proposalVotes.stream().collect(Collectors.toSet());
    }

    public List<Object[]> getTopListOfProposals(){
        Session session = sessionFactory.getCurrentSession();
        return  session.createNativeQuery("SELECT proposal.id, proposal.title, COUNT(vote.id_proposal) " +
                "as votesNo FROM proposal INNER JOIN vote ON vote.id_proposal = proposal.id GROUP BY(vote.id_proposal) " +
                "ORDER BY(votesNo) DESC;").list();

    }




}
