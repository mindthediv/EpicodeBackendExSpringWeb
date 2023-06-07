package com.pack.appfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pack.appfiles.models.Building;
import com.pack.appfiles.models.Workplace;
import com.pack.appfiles.models.Workplace.type;

import java.util.List;


public interface WorkplaceRepo extends JpaRepository<Workplace, Long> {
    List<Workplace> findByBuilding(Building building);
    List<Workplace> findByType(type type);
}
