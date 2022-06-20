package tn.esprit.spring.services;


import tn.esprit.spring.entities.Mission;

import java.util.List;

public interface IMissionService {
    public int ajouterMission(Mission mission);
    List<Mission> getAlMissions();
    Mission getMission(int missionId);
    public void deleteMissionById(int missionId);

}
