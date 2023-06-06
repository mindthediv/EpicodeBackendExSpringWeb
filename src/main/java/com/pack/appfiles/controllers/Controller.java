package com.pack.appfiles.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pack.appfiles.common.Common;
import com.pack.appfiles.models.Building;
import com.pack.appfiles.models.Reservation;
import com.pack.appfiles.models.User;
import com.pack.appfiles.models.Workplace;
import com.pack.appfiles.models.Workplace.type;
import com.pack.appfiles.services.BuildingService;
import com.pack.appfiles.services.ReservationService;
import com.pack.appfiles.services.UserService;
import com.pack.appfiles.services.WorkplaceService;

@org.springframework.stereotype.Controller
@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    public UserService userService;
    @Autowired
    public BuildingService buildingService;
    @Autowired
    public WorkplaceService workplaceService;
    @Autowired
    public ReservationService reservationService;
    
    //GET RuleSet *****************
    @GetMapping("/ruleSet")
    public String getRuleSet() {
        return Common.ruleSet;
    }
    @GetMapping("/ruleSet/{lang}")
    public String getRuleSet(@PathVariable String lang) {
        if(lang.equals("it")){
        return Common.ruleSetIt;
        } else {
            return "Language not avaible" + Common.ruleSet;
        }
    }


    //User *********************
    //GET
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id){
        return userService.findUserById(id).get();
    }
    //POST
    //User
    @PostMapping(value = "/users", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public String addUser(@RequestBody User user){
        user = userService.createUser(user.getUsername(),user.getFull_name(),user.getEmail());
        return "added user: " + user.toString();
    }
    
    //Building *******************
    //GET
    @GetMapping("/buildings/{id}")
    public Building getBuilding(@PathVariable long id){
        return buildingService.findBuildingById(id).get();
    }
    //POST
    @PostMapping(value = "/buildings", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public String addBuilding(@RequestBody Building building){
        building = buildingService.createBuilding(building.getCity(), building.getAddress());
        return "added building: " + building.toString();
    }

    //Workplaces *******************
    //GET
    @GetMapping("/workplaces/{id}")
    public Workplace getWorkplace(@PathVariable long id){
        return workplaceService.findWorkplaceById(id).get();
    }
    //POST
    @PostMapping(value = "/workplaces", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public String addPrivateWp(@RequestBody Workplace workplace){
        workplace = workplaceService.createWorkplace(workplace.getDescription(), workplace.getType(), workplace.getMax_capacity(), workplace.getBuilding().getBuilding_id());
        return "added workplace: " + workplace.toString();
    }   

    //Reservations *******************
    //GET
    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable long id){
        return reservationService.findReservationById(id).get();
    }
    //POST
    @PostMapping(value = "/reservations", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public String addReservation(@RequestBody Reservation reservation){
        reservation = reservationService.createReservation(reservation.getDate());
        return "added workplace: " + reservation.toString();
    }   
}
