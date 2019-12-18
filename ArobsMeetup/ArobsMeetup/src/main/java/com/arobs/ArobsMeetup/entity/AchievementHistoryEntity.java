package com.arobs.ArobsMeetup.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
@NoArgsConstructor

@Entity( name = "AchievementHistoryEntity")
@Table(name = "achievementhistory")
public class AchievementHistoryEntity {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    @NonNull
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prize", referencedColumnName = "id")
    @NonNull
    private PrizeEntity prize;

    @Column(name = "points") @NonNull
    int points;

    @Column(name = "date_time") @NonNull
    Timestamp date_time;
}
