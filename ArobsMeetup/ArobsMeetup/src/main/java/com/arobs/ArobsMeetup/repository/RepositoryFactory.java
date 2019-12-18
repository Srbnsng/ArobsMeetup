package com.arobs.ArobsMeetup.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFactory {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProposalRepository proposalRepository;
    @Autowired
    EventRepository eventRepository;

    public IRepository createRepository(String type){

        if(type.equals("USER")){
            return userRepository;
        }
        if(type.equals("PROPOSAL")){
            return proposalRepository;
        }
        if(type.equals("EVENT")){
            return eventRepository;
        }

        return null;
    }
}
