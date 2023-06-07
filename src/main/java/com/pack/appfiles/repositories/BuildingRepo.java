package com.pack.appfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pack.appfiles.models.Building;
import java.util.List;


public interface BuildingRepo extends JpaRepository<Building, Long>{
    List<Building> findByCity(String city);
}
