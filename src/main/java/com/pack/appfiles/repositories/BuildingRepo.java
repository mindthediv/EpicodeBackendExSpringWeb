package com.pack.appfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.pack.appfiles.models.Building;

public interface BuildingRepo extends JpaRepository<Building, Long>{
    @Query("SELECT b FROM Building b WHERE b.city = 'Rome'")
    Building getRomeBuilding();
    @Query("SELECT b FROM Building b WHERE b.city = 'Milan'")
    Building getMilanBuilding();
}
