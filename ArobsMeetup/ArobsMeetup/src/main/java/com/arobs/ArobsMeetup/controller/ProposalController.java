package com.arobs.ArobsMeetup.controller;


import com.arobs.ArobsMeetup.service.UserService;
import com.arobs.ArobsMeetup.service.dto.ProposalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.sql.SQLException;

@RestController
@RequestMapping("/proposals")
public class ProposalController {

    @Autowired
    UserService userService;

    @PostMapping(path ="/new")
    public ResponseEntity<Void> createProposal(@RequestBody ProposalDTO proposalDTO){

        try {
            boolean created = userService.createProposal(proposalDTO);
            if(created){
                return ResponseEntity.created(URI.create("/")).build();
            }
            else{
                return ResponseEntity.badRequest().build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
