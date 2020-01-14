package com.arobs.ArobsMeetup.service.proposal;

import com.arobs.ArobsMeetup.constants.ProposalConstants;
import com.arobs.ArobsMeetup.entity.ProposalEntity;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.constants.RepositoryConstants;
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

    void createProposal(ProposalDTO proposalDTO) throws Exception{
        IRepository repository = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        if(isValidDifficulty(proposalDTO.getDifficulty()) && isValidType(proposalDTO.getType())){
            ProposalEntity proposalEntity = proposalMapper.map(proposalDTO,ProposalEntity.class);
            repository.add(proposalEntity);
        }
    }

    private boolean isValidDifficulty(String difficulty) throws Exception {
        if(difficulty.equals(ProposalConstants.DIFFICULTY_EASY))
            return true;
        if(difficulty.equals(ProposalConstants.DIFFICULTY_MEDIUM))
            return true;
        if(difficulty.equals(ProposalConstants.DIFFICULTY_HIGH))
            return true;
        else
            throw new Exception("Proposal difficulty not valid! ");
    }

    private boolean isValidType(String type) throws Exception {
        if(type.equals(ProposalConstants.PITCH_TYPE))
            return true;
        if(type.equals(ProposalConstants.PRESENTATION_TYPE))
            return true;
        if(type.equals(ProposalConstants.WORKSHOP_TYPE))
            return true;
        if(type.equals(ProposalConstants.TECHNICAL_TYPE))
            return true;
        else
            throw new Exception("Proposal type is not valid! ");
    }

    void deleteProposal(int id) throws Exception {
        IRepository repository = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        ProposalEntity proposal = (ProposalEntity)repository.find(id);
        if(proposal != null){
            repository.remove(proposal);
        }
        else{
            throw new Exception("Proposal id not found! ");
        }
    }
    void alterProposal(int id, ProposalDTO proposalDTO) throws Exception {
        IRepository repository = factory.createRepository(RepositoryConstants.PROPOSAL_REPOSITORY_TYPE);
        ProposalEntity proposalEntity = (ProposalEntity)repository.find(id);
        if(proposalEntity != null){
            proposalEntity.setTitle(proposalDTO.getTitle());
            proposalEntity.setDescription(proposalDTO.getDescription());
            proposalEntity.setDuration(proposalDTO.getDuration());
            proposalEntity.setDifficulty(proposalDTO.getDifficulty().toString());
            proposalEntity.setLanguage(proposalDTO.getLanguage());
            proposalEntity.setMax_attends(proposalDTO.getMax_attends());
            proposalEntity.setProposer(proposalDTO.getProposer());
            repository.update(proposalEntity);
        }
        else{
            throw new Exception("Proposal id not found! ");
        }

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
