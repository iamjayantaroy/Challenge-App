package com.jayanta.Challenge_App.controller;

import com.jayanta.Challenge_App.entity.Challenge;
import com.jayanta.Challenge_App.service.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengeController {
    @Autowired
    private ChallengeService challengeService;


    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChalenges();
    }

    @PostMapping("/challenges")
    public String  addChallenge(@RequestBody Challenge challenge){
        boolean isChalengeAdded =  challengeService.addChallenge(challenge);
        if (isChalengeAdded){
            return "Challenge added successfully";
        }
        else {
            return "Challenge Not added successfully";
        }
    }

//    @GetMapping("/challenges/{id}")
//    public Challenge getChallengeById(@PathVariable Long id){
//        Challenge challenge = challengeService.getChellengeById(id);
//        if (challenge != null){
//            return challenge;
//        }
//        return null;
//    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallengeByMonth(@PathVariable String month){
        Challenge challenge = challengeService.getChellengeByMonth(month);
        if (challenge != null){
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
