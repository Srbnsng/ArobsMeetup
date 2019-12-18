package com.arobs.ArobsMeetup.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor

@Entity(name = "AttendanceEntity")
@Table(name= "attendance")
public class AttendanceEntity {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY) @NonNull
    @JoinColumn(name = "id_event", referencedColumnName = "id_event")
    private EventEntity event;

    @ManyToOne(fetch = FetchType.LAZY) @NonNull
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "mark") @NonNull
    private int mark;

    @Column(name = "note" , length = 50) @NonNull
    private String note;

}
