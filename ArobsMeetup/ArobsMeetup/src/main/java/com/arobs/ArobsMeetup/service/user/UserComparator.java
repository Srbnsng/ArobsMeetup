package com.arobs.ArobsMeetup.service.user;

import com.arobs.ArobsMeetup.entity.UserEntity;

import java.util.Comparator;

public class UserComparator implements Comparator<UserEntity> {
    @Override
    public int compare(UserEntity o1, UserEntity o2) {
        return o1.getPoints() - o2.getPoints();
    }
}
