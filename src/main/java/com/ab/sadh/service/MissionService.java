package com.ab.sadh.service;

import com.ab.sadh.model.Mission;

import java.util.List;

public interface MissionService {

    void addMission(Mission mission);

    void deleteMission(Mission mission);

    List<Mission> getAllMissions();
}
