package com.arobs.ArobsMeetup.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "PrizeEntity")
@Table(name = "prize")
public class PrizeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "pdescription")
    private String description;
    @Column(name = "pvalue")
    private int value;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "prize")
    private Set<AchievementHistoryEntity> achievementsHistories = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<AchievementHistoryEntity> getAchievementsHistories() {
        return achievementsHistories;
    }

    public void setAchievementsHistories(Set<AchievementHistoryEntity> achievementsHistories) {
        this.achievementsHistories = achievementsHistories;
    }
}
