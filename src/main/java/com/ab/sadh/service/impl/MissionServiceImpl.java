package com.ab.sadh.service.impl;

import com.ab.sadh.model.Mission;
import com.ab.sadh.repository.MissionsRepository;
import com.ab.sadh.service.MissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MissionServiceImpl implements MissionService {

    private final MissionsRepository missionsRepository;

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
