package com.arobs.ArobsMeetup.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Entity(name = "UserEntity")
@Table(name = "user")
public class UserEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "passwrd" , length = 30) @NonNull
    private String password;

    @Column(name = "full_name" ,length = 50) @NonNull
    private String full_name;

    @Column(name = "urole" , length = 30) @NonNull
    private String role;

    @Column(name = "email" , length = 30) @NonNull
    private String email;

    @Column(name = "points")
    private int points;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "proposer")
    private List<ProposalEntity> proposals = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true ,mappedBy = "user")
    private List<VoteEntity> votes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,mappedBy = "user")
    private List<AttendanceEntity> attendances = new ArrayList<>();





    public UserEntity(int id, String password, String full_name, String role, String email, int points) {
        this.id = id;
        this.password = password;
        this.full_name = full_name;
        this.role = role;
        this.email = email;
        this.points = points;
    }

}
