package com.pack.appfiles.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pack.appfiles.common.Common;
import com.pack.appfiles.models.Building;
import com.pack.appfiles.models.Reservation;
import com.pack.appfiles.models.User;
import com.pack.appfiles.models.Workplace;
import com.pack.appfiles.repositories.BuildingRepo;
import com.pack.appfiles.repositories.ReservationRepo;
import com.pack.appfiles.repositories.UserRepo;
import com.pack.appfiles.repositories.WorkplaceRepo;
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
    @Autowired
    public UserRepo userRepo;
    @Autowired
    public BuildingRepo buildingRepo;
    @Autowired
    public WorkplaceRepo workplaceRepo;
    @Autowired
    public ReservationRepo reservationRepo;
    
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
    //PUT
    @PutMapping("/users/{id}")
    public ResponseEntity<?> putUser(@PathVariable long id, @RequestBody Optional<User> userDto) throws Exception{
        Optional<User> optUser = userService.findUserById(id);
        if (optUser.isPresent()){
            User u = optUser.get();
            if(!userDto.get().getEmail().equals(null)){
            u.setEmail(userDto.get().getEmail());
            }
            if(!userDto.get().getFull_name().equals(null)){
            u.setFull_name((userDto.get().getFull_name()));
            }
            if(!userDto.get().getUsername().equals(null)){
            u.setUsername(userDto.get().getUsername());
            }
            userService.updateUser(u);
            System.out.println("updated user: "+ u.toString());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //POST
    @PostMapping(value = "/users")
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
    @PostMapping(value = "/buildings")
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
    @PostMapping(value = "/workplaces")
    public String addPrivateWp(@RequestBody Workplace workplace, @RequestParam long id){
        workplace = workplaceService.createWorkplace(workplace.getDescription(), workplace.getType(), workplace.getMax_capacity(), buildingService.findBuildingById(id).get());
        return "added workplace: " + workplace.toString();
    }   

    //Reservations *******************
    //GET
    @GetMapping("/reservations/{id}")
    public Reservation getReservation(@PathVariable long id){
        System.out.println(reservationService.findReservationById(id).get().getWorkplace());
        System.out.println(reservationService.findReservationById(id).get().getUser());
        return reservationService.findReservationById(id).get();
    }
    //POST
    @PostMapping(value = "/reservations/{user_id}")
    public String addReservation(@RequestBody Reservation reservation,@PathVariable long user_id, @RequestParam long workplace_id) throws Exception{
        reservation = reservationService
        .createReservation(reservation.getDate(),
        userService.findUserById(user_id).get(),
        workplaceService.findWorkplaceById(workplace_id).get());
        return "added reservation: " + reservation.toString(); 
    }   
}
