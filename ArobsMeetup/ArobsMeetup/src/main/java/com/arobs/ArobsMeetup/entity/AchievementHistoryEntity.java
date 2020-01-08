package com.arobs.ArobsMeetup.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity( name = "AchievementHistoryEntity")
@Table(name = "achievementhistory")
public class AchievementHistoryEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prize", referencedColumnName = "id")
    private PrizeEntity prize;

    @Column(name = "points")
    private int points;

    @Column(name = "date_time")
    private Date date_time;

    public AchievementHistoryEntity(UserEntity user, PrizeEntity prize, int points, Date date_time) {
        this.user = user;
        this.prize = prize;
        this.points = points;
        this.date_time = date_time;
    }

    public AchievementHistoryEntity() {

    }

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

    public PrizeEntity getPrize() {
        return prize;
    }

    public void setPrize(PrizeEntity prize) {
        this.prize = prize;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }
}
