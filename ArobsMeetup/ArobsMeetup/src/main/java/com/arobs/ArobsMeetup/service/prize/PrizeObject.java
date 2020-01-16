package com.arobs.ArobsMeetup.service.prize;

import com.arobs.ArobsMeetup.constants.RepositoryConstants;
import com.arobs.ArobsMeetup.entity.PrizeEntity;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.repository.RepositoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PrizeObject {

    @Autowired
    private RepositoryFactory factory;
    @Autowired
    private PrizeMapper prizeMapper;


    public void addPrize(PrizeDTO prizeDTO){
        IRepository prize_repo = factory.createRepository(RepositoryConstants.PRIZE_REPOSITORY_TYPE);
        PrizeEntity prizeEntity = prizeMapper.map(prizeDTO,PrizeEntity.class);
        prize_repo.add(prizeEntity);

    }
    public void alterPrize(int id , PrizeDTO prizeDTO) throws Exception {
        IRepository prize_repo = factory.createRepository(RepositoryConstants.PRIZE_REPOSITORY_TYPE);
        PrizeEntity prizeEntity = (PrizeEntity)prize_repo.find(id);
        if(prizeEntity != null){
            prizeEntity.setDescription(prizeDTO.getDescription());
            prizeEntity.setValue(prizeDTO.getValue());
            prize_repo.update(prizeEntity);
        }
        else{
            throw new Exception("Prize id not found! ");
        }

    }

    public void removePrize(int id) throws Exception {
        IRepository prize_repo = factory.createRepository(RepositoryConstants.PRIZE_REPOSITORY_TYPE);
        PrizeEntity prizeEntity = (PrizeEntity)prize_repo.find(id);
        if(prizeEntity != null){
            prize_repo.remove(prizeEntity);
        }
        else{
            throw new Exception("Prize id not found! ");
        }
    }

    public PrizeDTO findPrize(int id){
        IRepository prize_repo = factory.createRepository(RepositoryConstants.PRIZE_REPOSITORY_TYPE);
        PrizeEntity prizeEntity = (PrizeEntity)prize_repo.find(id);
        if(prizeEntity!=null){
            return prizeMapper.map(prizeEntity,PrizeDTO.class);
        }
        return null;
    }

    public List<PrizeDTO> findAllPrizes(){
        IRepository prize_repo = factory.createRepository(RepositoryConstants.PRIZE_REPOSITORY_TYPE);
        List<PrizeEntity> prizes = prize_repo.findAll();
        if(prizes!=null){
            return prizeMapper.mapAsList(prizes,PrizeDTO.class);
        }
        return null;
    }
}
