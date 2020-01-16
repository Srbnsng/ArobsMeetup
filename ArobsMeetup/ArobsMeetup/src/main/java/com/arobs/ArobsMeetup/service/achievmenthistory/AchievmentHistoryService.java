package com.arobs.ArobsMeetup.service.achievmenthistory;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface AchievmentHistoryService {

    void addAchievement(int user_id, int prize_id , Date date) throws Exception;
    void removeAchievement(int id) throws Exception;
    void alterAchievement(int id,AchievmentHistoryDTO achievement) throws Exception;
    AchievmentHistoryDTO findAchievement(int id);
    List<AchievmentHistoryDTO> findAllAchievements();
}
