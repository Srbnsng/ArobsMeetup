package com.arobs.ArobsMeetup.service.proposal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProposalService {

    void createProposal(ProposalDTO proposalDTO);
    void deleteProposal(int id);
    void alterProposal(int id, ProposalDTO proposalDTO);
    ProposalDTO findProposal(int id);
    List<ProposalDTO> findAllProposals();
}
