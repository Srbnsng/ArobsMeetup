package com.arobs.ArobsMeetup.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "PrizeEntity")
@Table(name = "prize")
public class PrizeEntity {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "pdescription")
    private String description;
    @Column(name = "pvalue")
    private int values;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true , mappedBy = "prize")
    private List<AchievementHistoryEntity> achievementsHistories = new ArrayList<>();

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

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

    public List<AchievementHistoryEntity> getAchievementsHistories() {
        return achievementsHistories;
    }

    public void setAchievementsHistories(List<AchievementHistoryEntity> achievementsHistories) {
        this.achievementsHistories = achievementsHistories;
    }
}
