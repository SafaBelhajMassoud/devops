package tn.esprit.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;

import java.util.List;

@RestController
public class RestControllerMission {
    @Autowired
    IMissionService imissionservice;


    @PostMapping("/addMission")
    @ResponseBody
    public int addMission(@RequestBody Mission mission) {
        imissionservice.ajouterMission(mission);
        return mission.getId();
    }

    @GetMapping(value = "/getAllMissions")
    @ResponseBody
    public List<Mission> getMissions() {
        return imissionservice.getAlMissions();
    }
    @DeleteMapping("/deleteMission")
    @ResponseBody
    public void deletesMissionByMissionId(@PathVariable("missionId") int missionId) {
        imissionservice.deleteMissionById(missionId);
    }
    @GetMapping(value = "/getMissionById/{missionId}")
    @ResponseBody
    public Mission getMissionByMissionId(@PathVariable("missionId") int missionId) {
        return imissionservice.getMission(missionId);
    }
}
