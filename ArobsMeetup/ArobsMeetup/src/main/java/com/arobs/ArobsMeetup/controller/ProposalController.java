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
    public ResponseEntity<List<ProposalDTO>> findAllProposals() {
        return ResponseEntity.ok(proposalService.findAllProposals());
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createProposal(@RequestBody ProposalDTO proposalDTO){
        proposalService.createProposal(proposalDTO);
        return ResponseEntity.ok("New Proposal created! ");
    }

    @DeleteMapping(path ="/deleteProposal/{id}")
    public ResponseEntity<String> deleteProposal(@PathVariable int id){
        try {
            proposalService.deleteProposal(id);
            return ResponseEntity.ok("Proposal with id " + id + " deleted! ");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }

    }
    @PutMapping(path = "/updateProposal/{id}")
    public ResponseEntity<String> updateProposal(@PathVariable int id, @RequestBody ProposalDTO proposalDTO){
        try {
            proposalService.alterProposal(id,proposalDTO);
            return ResponseEntity.ok("Proposal with id " + id + " updated! ");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }

    }
}
