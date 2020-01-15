package com.arobs.ArobsMeetup.controller;

import com.arobs.ArobsMeetup.service.prize.PrizeDTO;
import com.arobs.ArobsMeetup.service.prize.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prizes")
public class PrizeController {

    @Autowired
    PrizeService prizeService;

    @PostMapping(path = "/addPrize")
    public ResponseEntity<String> addPrize(@RequestBody PrizeDTO prizeDTO){

        prizeService.add(prizeDTO);
        return ResponseEntity.ok("New prize added! ");
    }
}
