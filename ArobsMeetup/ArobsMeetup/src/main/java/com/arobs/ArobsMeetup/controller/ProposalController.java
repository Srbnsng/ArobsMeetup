package com.arobs.ArobsMeetup.controller;

import com.arobs.ArobsMeetup.service.proposal.ProposalDTO;
import com.arobs.ArobsMeetup.service.proposal.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposals")
public class ProposalController {

    @Autowired
    ProposalService proposalService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<ProposalDTO> findProposalById(@PathVariable int id){
        return ResponseEntity.ok(proposalService.findProposal(id));
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<ProposalDTO>> findAllUsers() {
        return ResponseEntity.ok(proposalService.findAllProposals());
    }

    @PostMapping(path = "/create")
    public String createProposal(@RequestBody ProposalDTO proposalDTO){
        proposalService.createProposal(proposalDTO);
        return "HTTP Create method called!";
    }

    @DeleteMapping(path ="/{id}")
    public String deleteProposal(@PathVariable int id){
        proposalService.deleteProposal(id);
        return "HTTP Delete method called!";
    }
    @PutMapping(path = "/{id}")
    public String updateProposal(@PathVariable int id, @RequestBody ProposalDTO proposalDTO){
        proposalService.alterProposal(id,proposalDTO);
        return "HTTP update method called! ";
    }
}
