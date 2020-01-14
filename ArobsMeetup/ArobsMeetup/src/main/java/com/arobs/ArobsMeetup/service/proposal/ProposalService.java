package com.arobs.ArobsMeetup.service.proposal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProposalService {

    void createProposal(ProposalDTO proposalDTO) throws Exception;
    void deleteProposal(int id) throws Exception;
    void alterProposal(int id, ProposalDTO proposalDTO) throws Exception;
    ProposalDTO findProposal(int id);
    List<ProposalDTO> findAllProposals();
}
