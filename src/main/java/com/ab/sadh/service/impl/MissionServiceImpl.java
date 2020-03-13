package com.ab.sadh.service.impl;

import com.ab.sadh.model.Mission;
import com.ab.sadh.repository.MissionsRepository;
import com.ab.sadh.service.MissionService;
<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MissionServiceImpl implements MissionService {

    private final MissionsRepository missionsRepository;

<<<<<<< HEAD
=======
    @Autowired
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
    public MissionServiceImpl(MissionsRepository missionsRepository) {
        this.missionsRepository = missionsRepository;
    }

    @Override
    public void addMission(Mission mission) {
        missionsRepository.save(mission);
    }

    @Override
    public void deleteMission(Mission mission) {
        missionsRepository.delete(mission);
    }

    @Override
    public List<Mission> getAllMissions() {
        return StreamSupport.stream(missionsRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
