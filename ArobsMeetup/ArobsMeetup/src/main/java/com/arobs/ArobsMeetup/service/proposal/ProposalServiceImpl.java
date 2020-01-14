package com.arobs.ArobsMeetup.service.proposal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProposalServiceImpl implements ProposalService {

    @Autowired
    private ProposalObject proposalObject;

    @Override @Transactional
    public void createProposal(ProposalDTO proposalDTO) throws Exception {
        proposalObject.createProposal(proposalDTO);
    }

    @Override @Transactional
    public void deleteProposal(int id) throws Exception {
        proposalObject.deleteProposal(id);
    }

    @Override @Transactional
    public void alterProposal(int id, ProposalDTO proposalDTO) throws Exception {
        proposalObject.alterProposal(id,proposalDTO);
    }
    @Override @Transactional
    public ProposalDTO findProposal(int id) {
        return proposalObject.findProposal(id);
    }

    @Override @Transactional
    public List<ProposalDTO> findAllProposals() {
        return proposalObject.findAllProposals();
    }
}
