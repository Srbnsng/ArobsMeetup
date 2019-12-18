package com.arobs.ArobsMeetup.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="proposal")
public class ProposalEntity {
    @Id @GeneratedValue
    @Column(name="id")@NonNull
    private int id;

    @Column(name="title" , length = 30)@NonNull
    private String title;

    @ManyToOne(fetch = FetchType.LAZY) @NonNull
    @JoinColumn(name = "proposer_id" , referencedColumnName = "id")
    private UserEntity proposer;

    @Column(name="description" , length = 100)@NonNull
    private String description;

    @Column(name="ptype" , length = 30)@NonNull
    private String type;

    @Column(name="difficulty")@NonNull
    private String difficulty;

    @Column(name="planguage" , length = 30)@NonNull
    private String language;

    @Column(name="duration") @NonNull @Min(0)
    private int duration;

    @Column(name = "max_attends") @NonNull @Min(0)
    private int max_attends;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "proposal")
    List<VoteEntity> votes = new ArrayList<>();


    public ProposalEntity(int id, String title, UserEntity proposer, String description, String type, String difficulty, String language, int duration, int max_attends) {
        this.id = id;
        this.title = title;
        this.proposer = proposer;
        this.description = description;
        this.type = type;
        this.difficulty = difficulty;
        this.language = language;
        this.duration = duration;
        this.max_attends = max_attends;
        //this.votes = votes;
    }

    public ProposalEntity(String title, UserEntity proposer, String description, String type, String difficulty, String language,int duration, int max_attends) {
        this.title = title;
        this.proposer = proposer;
        this.description = description;
        this.type = type;
        this.difficulty = difficulty;
        this.language = language;
        this.duration = duration;
        this.max_attends = max_attends;
        //this.votes = 0;
    }
}
