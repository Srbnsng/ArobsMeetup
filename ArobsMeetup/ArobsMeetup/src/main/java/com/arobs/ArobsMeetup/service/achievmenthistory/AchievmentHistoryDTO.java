package com.arobs.ArobsMeetup.service.achievmenthistory;

import com.arobs.ArobsMeetup.entity.PrizeEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;

import java.util.Date;

public class AchievmentHistoryDTO {

    private int id;
    private UserEntity user;
    private PrizeEntity prize;
    private int points;
    private Date date;


    public AchievmentHistoryDTO(UserEntity user, PrizeEntity prize, Date date) {
        this.user = user;
        this.prize = prize;
        this.points = user.getPoints();
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
