package com.arobs.ArobsMeetup.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Entity(name = "PrizeEntity")
@Table(name = "prize")
public class PrizeEntity {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "pdescription") @NonNull
    private String description;
    @Column(name = "pvalue") @NonNull
    private int values;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "prize")
    private List<AchievementHistoryEntity> achievementsHistories = new ArrayList<>();

}
