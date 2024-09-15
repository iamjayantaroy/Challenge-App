package com.jayanta.Challenge_App.service;

import com.jayanta.Challenge_App.entity.Challenge;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();

    public List<Challenge> getAllChalenges(){
        return challenges;
    }

    public Boolean addChallenge(Challenge challenge){
        if (challenge != null){
            challenges.add(challenge);
            return true;
        }
        return false;
    }

//    public Challenge getChellengeById(Long id){
//        for (Challenge challenge: challenges){
//            if(challenge.getId().equals(id)){
//                return challenge;
//            }
//        }
//        return null;
//    }

    public Challenge getChellengeByMonth(String month){
        for (Challenge challenge: challenges){
            if(challenge.getMonth().equalsIgnoreCase(month)){
                return challenge;
            }
        }
        return null;
    }
}
