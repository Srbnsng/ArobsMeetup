package com.arobs.ArobsMeetup.service;

import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.service.dto.ProposalDTO;
import com.arobs.ArobsMeetup.service.dto.VoteDTO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public interface UserService {

    boolean createProposal (ProposalDTO proposalDTO) throws SQLException;

    void voteToggle(VoteDTO voteDTO) throws SQLException;

    void acceptProposal(ProposalDTO proposalDTO);
}
