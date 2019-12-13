package com.arobs.ArobsMeetup.service;

import com.arobs.ArobsMeetup.domain.Proposal;
import com.arobs.ArobsMeetup.domain.enums.Difficulty;
import com.arobs.ArobsMeetup.domain.enums.Type;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public interface IUserService {

    Proposal createProposal (String title, int proposer_id, String desc, Type type,
                                   Difficulty diff, String lang, double duration, int maxattends) throws SQLException;

    void voteToggle(int proposal_id,int user_id) throws SQLException;
}
