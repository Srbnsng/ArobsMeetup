package com.arobs.ArobsMeetup.service;

import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.service.dto.ProposalDTO;
import com.arobs.ArobsMeetup.service.dto.VoteDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserObject userObject;

    @Override
    public boolean createProposal(ProposalDTO proposalDTO) throws SQLException {
        return userObject.createProposal(proposalDTO);
    }

    @Override
    public void voteToggle(VoteDTO voteDTO) throws SQLException {
        userObject.voteToggle(voteDTO);
    }

    @Override
    public void acceptProposal(ProposalDTO proposalDTO) {

    }


}
