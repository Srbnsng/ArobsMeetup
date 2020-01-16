package com.arobs.ArobsMeetup.service.achievmenthistory;

import com.arobs.ArobsMeetup.constants.RepositoryConstants;
import com.arobs.ArobsMeetup.entity.AchievementHistoryEntity;
import com.arobs.ArobsMeetup.entity.PrizeEntity;
import com.arobs.ArobsMeetup.entity.UserEntity;
import com.arobs.ArobsMeetup.repository.IRepository;
import com.arobs.ArobsMeetup.repository.RepositoryFactory;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AchievmentHistoryObject {

    @Autowired
    private RepositoryFactory factory;
    @Autowired
    private AchievmentHistoryMapper achievmentHistoryMapper;

    public void addAchievement(int user_id, int prize_id, Date date) throws Exception {

        IRepository achievement_repo = factory.createRepository(RepositoryConstants.ACHIEVEMENT_REPOSITORY_TYPE);
        IRepository user_repo = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        IRepository prize_repo = factory.createRepository(RepositoryConstants.PRIZE_REPOSITORY_TYPE);
        UserEntity userEntity = (UserEntity) user_repo.find(user_id);
        PrizeEntity prizeEntity = (PrizeEntity) prize_repo.find(prize_id);
        if(userEntity==null){
            throw new Exception("User id not found! ");
        }
        if(prizeEntity==null){
            throw new Exception("Prize id not found! ");
        }
        achievement_repo.add(new AchievementHistoryEntity(userEntity,prizeEntity,date));
        resetPointsToAllUsers();

    }

    public void resetPointsToAllUsers(){
        IRepository user_repo = factory.createRepository(RepositoryConstants.USER_REPOSITORY_TYPE);
        List<UserEntity> users = user_repo.findAll();
        for(UserEntity user : users){
            user.setPoints(0);
            user_repo.update(user);
        }
    }

    public void removeAchievement(int id) throws Exception {
        IRepository achievement_repo = factory.createRepository(RepositoryConstants.ACHIEVEMENT_REPOSITORY_TYPE);
        AchievementHistoryEntity achievement = (AchievementHistoryEntity) achievement_repo.find(id);
        if(achievement!=null){
            achievement_repo.remove(achievement);
        }
        else{
            throw new Exception("Achievement id not found ! ");
        }
    }

    public void updateAchievement(int id , AchievmentHistoryDTO achievmentHistoryDTO) throws Exception {
        IRepository achievement_repo = factory.createRepository(RepositoryConstants.ACHIEVEMENT_REPOSITORY_TYPE);
        AchievementHistoryEntity achievement = (AchievementHistoryEntity) achievement_repo.find(id);
        if (achievement != null) {
            achievement.setUser(achievmentHistoryDTO.getUser());
            achievement.setPrize(achievmentHistoryDTO.getPrize());
            achievement.setPoints(achievmentHistoryDTO.getPoints());
            achievement.setDate_time(achievmentHistoryDTO.getDate());
            achievement_repo.update(achievement);
        } else {
            throw new Exception("Achievement id not found ! ");
        }
    }

    public AchievmentHistoryDTO findAchievement(int id){
        IRepository achievement_repo = factory.createRepository(RepositoryConstants.ACHIEVEMENT_REPOSITORY_TYPE);
        AchievementHistoryEntity achievement = (AchievementHistoryEntity) achievement_repo.find(id);
        return achievmentHistoryMapper.map(achievement,AchievmentHistoryDTO.class);
    }

    public List<AchievmentHistoryDTO> findAllAchievements(){
        IRepository achievement_repo = factory.createRepository(RepositoryConstants.ACHIEVEMENT_REPOSITORY_TYPE);
        List<AchievementHistoryEntity> achievement =  achievement_repo.findAll();
        return achievmentHistoryMapper.mapAsList(achievement,AchievmentHistoryDTO.class);
    }


}
