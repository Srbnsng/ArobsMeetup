package com.arobs.ArobsMeetup.entity;
import javax.persistence.*;

@Entity(name = "VoteEntity")
@Table(name = "vote")
public class VoteEntity {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proposal" , referencedColumnName = "id")
    private ProposalEntity proposal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProposalEntity getProposal() {
        return proposal;
    }

    public void setProposal(ProposalEntity proposal) {
        this.proposal = proposal;
    }
}
