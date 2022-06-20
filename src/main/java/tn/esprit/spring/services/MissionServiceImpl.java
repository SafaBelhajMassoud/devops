package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;
import java.util.List;

@Service
public class MissionServiceImpl implements  IMissionService{
    @Autowired
    MissionRepository missionRepoistory;
    @Override
    public int ajouterMission(Mission mission) {
        missionRepoistory.save(mission);
        return mission.getId();
    }

    @Override
    public List<Mission> getAlMissions() {
            return (List<Mission>) missionRepoistory.findAll();
 }

    @Override
    public Mission getMission(int missionId) {
        return missionRepoistory.findById(missionId).get();
    }

    @Override
    public void deleteMissionById(int missionId) {
        missionRepoistory.delete(missionRepoistory.findById(missionId).get());

    }
}
