package com.arobs.ArobsMeetup.service.prize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class PrizeServiceImpl implements PrizeService{

    @Autowired
    PrizeObject prizeObject;

    @Override @Transactional
    public void add(PrizeDTO prizeDTO) {
        prizeObject.addPrize(prizeDTO);
    }

    @Override @Transactional
    public void alter(int id, PrizeDTO prizeDTO) throws Exception {
        prizeObject.alterPrize(id,prizeDTO);
    }

    @Override @Transactional
    public void remove(int id) throws Exception {
        prizeObject.removePrize(id);
    }

    @Override @Transactional
    public PrizeDTO find(int id) {
        return prizeObject.findPrize(id);
    }

    @Override @Transactional
    public List<PrizeDTO> findAll() {
        return prizeObject.findAllPrizes();
    }
}
