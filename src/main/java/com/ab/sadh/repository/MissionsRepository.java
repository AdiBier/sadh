package com.ab.sadh.repository;

import com.ab.sadh.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface MissionsRepository extends JpaRepository<Mission, String> {

    Mission findByName(String name);

    boolean existsByName(String name);

    List<Mission> findByStartDateAndFinishDateBefore(Timestamp startDate, Timestamp finishDate);
}
