package com.pack.appfiles.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.appfiles.models.Building;
import com.pack.appfiles.models.Workplace;
import com.pack.appfiles.models.Workplace.type;
import com.pack.appfiles.repositories.WorkplaceRepo;

@Service
public class WorkplaceService {
    @Autowired
   private WorkplaceRepo workplaceRepo;

    public void saveWorkplace(Workplace u){
        workplaceRepo.save(u);
    }

    public void updateWorkplace(Workplace u){
            workplaceRepo.save(u);
    }

    public void deleteWorkplace(Workplace u){
        workplaceRepo.delete(u);
    }

    public Optional<Workplace> findWorkplaceById(long id){
        return workplaceRepo.findById(id);
    }

    public Workplace createWorkplace(String d, type t, int c) {
        Workplace workplace =  new Workplace(d,t,c);
        workplaceRepo.save(workplace);
        return workplace;
    }

    // public Workplace createOpenSpace(Office office ) {
            // return openSpace.getObject();      
    // }

    // public Workplace createMeetingRoom(Office office ) {
            // return meetingRoom.getObject();      
    // }
}

