package com.pack.appfiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.appfiles.models.Building;
import com.pack.appfiles.repositories.BuildingRepo;


@Service
public class BuildingService {
@Autowired
   private BuildingRepo buildingRepo;

    public void saveBuilding(Building u){
        buildingRepo.save(u);
    }

    public void updateBuilding(Building u){
            buildingRepo.save(u);
    }

    public void deleteBuilding(Building u){
        buildingRepo.delete(u);
    }

    public Optional<Building> findBuildingById(long id){
        return buildingRepo.findById(id);
    }

    public Building createBuilding(String c,String a) {
        Building building =  new Building(c, a);
        buildingRepo.save(building);
        return building;
    }
}
