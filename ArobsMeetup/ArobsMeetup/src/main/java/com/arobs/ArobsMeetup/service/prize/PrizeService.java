package com.arobs.ArobsMeetup.service.prize;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PrizeService {

    void add(PrizeDTO prizeDTO);
    void alter(int id , PrizeDTO prizeDTO) throws Exception;
    void remove(int id) throws Exception;
    PrizeDTO find(int id);
    List<PrizeDTO> findAll();
}
