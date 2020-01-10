package com.arobs.ArobsMeetup.service.proposal;

import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.repository.RepositoryConstants;
import com.arobs.ArobsMeetup.repository.RepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProposalObject {

    @Autowired
    private RepositoryFactory factory;
    @Autowired
    private ProposalMapper proposalMapper;

    void createProposal(ProposalDTO proposalDTO){
        IRepository repository = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        ProposalEntity proposalEntity = proposalMapper.map(proposalDTO,ProposalEntity.class);
        repository.add(proposalEntity);
    }
    void deleteProposal(int id){
        IRepository repository = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        ProposalEntity proposal = (ProposalEntity)repository.find(id);
        if(proposal != null){
            repository.remove(proposal);
        }
    }
    void alterProposal(int id, ProposalDTO proposalDTO){
        IRepository repository = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        ProposalEntity proposalEntity = (ProposalEntity)repository.find(id);
        proposalEntity.setTitle(proposalDTO.getTitle());
        proposalEntity.setDescription(proposalDTO.getDescription());
        proposalEntity.setDuration(proposalDTO.getDuration());
        proposalEntity.setDifficulty(proposalDTO.getDifficulty().toString());
        proposalEntity.setLanguage(proposalDTO.getLanguage());
        proposalEntity.setMax_attends(proposalDTO.getMax_attends());
        proposalEntity.setProposer(proposalDTO.getProposer());
        repository.update(proposalEntity);
    }

    ProposalDTO findProposal(int id){
        IRepository repository = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        ProposalEntity proposalEntity = (ProposalEntity)repository.find(id);
        if(proposalEntity !=null)
            return proposalMapper.map(proposalEntity,ProposalDTO.class);

        return null;
    }
    List<ProposalDTO> findAllProposals(){
        IRepository repository = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        List<ProposalEntity> proposals = repository.findAll();
        if(proposals !=null)
            return proposalMapper.mapAsList(proposals,ProposalDTO.class);

        return null;
    }
}
