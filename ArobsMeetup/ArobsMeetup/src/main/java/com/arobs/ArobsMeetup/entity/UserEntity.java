package com.arobs.ArobsMeetup.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "UserEntity")
@Table(name = "user")
public class UserEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "passwrd" , length = 30)
    private String password;

    @Column(name = "full_name" ,length = 50)
    private String full_name;

    @Column(name = "urole" , length = 30)
    private String role;

    @Column(name = "email" , length = 30)
    private String email;

    @Column(name = "points")
    private int points;

    @ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(
            name = "vote",
            joinColumns = {@JoinColumn(name = "id_user", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id_proposal", referencedColumnName = "id")}
    )
    @JsonIgnore
    private Set<ProposalEntity> votedProposals = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "proposer")
    private Set<ProposalEntity> proposalsCreated = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "user")
    private Set<AttendanceEntity> eventsAttended = new HashSet<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "proposer")
    private Set<EventEntity> eventsCreated = new HashSet<>();





    public UserEntity(int id, String password, String full_name, String role, String email, int points) {
        this.id = id;
        this.password = password;
        this.full_name = full_name;
        this.role = role;
        this.email = email;
        this.points = points;
    }

    public UserEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Set<ProposalEntity> getVotedProposals() {
        return votedProposals;
    }

    public void setVotedProposals(Set<ProposalEntity> votedProposals) {
        this.votedProposals = votedProposals;
    }

    public Set<ProposalEntity> getProposalsCreated() {
        return proposalsCreated;
    }

    public void setProposalsCreated(Set<ProposalEntity> proposalsCreated) {
        this.proposalsCreated = proposalsCreated;
    }

    public Set<AttendanceEntity> getEventsAttended() {
        return eventsAttended;
    }

    public void setEventsAttended(Set<AttendanceEntity> eventsAttended) {
        this.eventsAttended = eventsAttended;
    }

    public Set<EventEntity> getEventsCreated() {
        return eventsCreated;
    }

    public void setEventsCreated(Set<EventEntity> eventsCreated) {
        this.eventsCreated = eventsCreated;
    }
}
