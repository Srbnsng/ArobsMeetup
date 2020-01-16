package com.arobs.ArobsMeetup.controller;

import com.arobs.ArobsMeetup.service.achievmenthistory.AchievmentHistoryDTO;
import com.arobs.ArobsMeetup.service.achievmenthistory.AchievmentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/achievementhistory")
public class AchievementHistoryController {

    @Autowired
    AchievmentHistoryService achievmentHistoryService;

    @PostMapping(path = "/addAchievement/{user_id}/{prize_id}/{date}")
    public ResponseEntity<String> addAchievement(@PathVariable int user_id , @PathVariable int prize_id ,
                                                 @PathVariable Date date){
        try {
            achievmentHistoryService.addAchievement(user_id,prize_id,date);
            return ResponseEntity.ok("Achievement added! ");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @GetMapping(path = "/getAchievements")
    public ResponseEntity<List<AchievmentHistoryDTO>> getAll(){
        return ResponseEntity.ok(achievmentHistoryService.findAllAchievements());
    }
}
