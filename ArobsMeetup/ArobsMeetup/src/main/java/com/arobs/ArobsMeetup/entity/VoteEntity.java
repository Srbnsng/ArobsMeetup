package com.arobs.ArobsMeetup.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Entity(name = "VoteEntity")
@Table(name = "vote")
public class VoteEntity {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY) @NonNull
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY) @NonNull
    @JoinColumn(name = "id_proposal" , referencedColumnName = "id")
    private ProposalEntity proposal;

}
