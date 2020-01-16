package com.arobs.ArobsMeetup.controller;

import com.arobs.ArobsMeetup.service.proposal.ProposalDTO;
import com.arobs.ArobsMeetup.service.proposal.VotedProposalDTO;
import com.arobs.ArobsMeetup.service.user.UserDTO;
import com.arobs.ArobsMeetup.service.vote.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Set;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    VoteService voteService;

    @PostMapping(path = "/createVote/user{user_id}/proposal{proposal_id}")
    public ResponseEntity<String> createVote(@PathVariable int user_id, @PathVariable int proposal_id) {
        try{
            voteService.addVote(user_id, proposal_id);
            return ResponseEntity.status(201).body("New Vote added!  ");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }


    }

    @DeleteMapping(path = "/removeVote/user{user_id}/proposal{proposal_id}")
    public ResponseEntity<String> removeVote(@PathVariable int user_id, @PathVariable int proposal_id){
        try{
            voteService.removeVote(user_id,proposal_id);
            return ResponseEntity.status(200).body("Vote deleted! ");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }

    }

    @GetMapping(path = "/getUserVotedProposals/user{user_id}")
    public ResponseEntity<Set<ProposalDTO>> getUserVotedProposals(@PathVariable int user_id){

        return ResponseEntity.ok(voteService.getUserVotes(user_id));
    }

    @GetMapping(path = "/getProposalVoters/proposal{proposal_id}")
    public ResponseEntity<Set<UserDTO>> getAllVotesOfAProposal(@PathVariable int proposal_id){
        return ResponseEntity.ok(voteService.getProposalVoters(proposal_id));
    }

    @GetMapping(path = "/getTopVotedProposalsList")
    public ResponseEntity<Set<VotedProposalDTO>> getTopVoteProposalsList(){
        return ResponseEntity.ok(voteService.getTopVotedProposalsList());
    }

}
