package com.arobs.ArobsMeetup.service.achievmenthistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
public class AchievmentHistoryServiceImpl implements AchievmentHistoryService {


    @Autowired
    AchievmentHistoryObject achievmentHistoryObject;

    @Override @Transactional
    public void addAchievement(int user_id, int prize_id, Date date) throws Exception {
        achievmentHistoryObject.addAchievement(user_id,prize_id,date);
    }

    @Override @Transactional
    public void removeAchievement(int id) throws Exception {
        achievmentHistoryObject.removeAchievement(id);
    }

    @Override @Transactional
    public void alterAchievement(int id, AchievmentHistoryDTO achievement) throws Exception {
        achievmentHistoryObject.updateAchievement(id,achievement);
    }

    @Override @Transactional
    public AchievmentHistoryDTO findAchievement(int id) {
        return achievmentHistoryObject.findAchievement(id);
    }

    @Override @Transactional
    public List<AchievmentHistoryDTO> findAllAchievements() {
        return achievmentHistoryObject.findAllAchievements();
    }
}
