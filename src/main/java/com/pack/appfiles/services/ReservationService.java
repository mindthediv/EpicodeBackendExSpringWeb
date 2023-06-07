package com.pack.appfiles.services;

import java.time.LocalDate;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pack.appfiles.models.Reservation;
import com.pack.appfiles.models.User;
import com.pack.appfiles.models.Workplace;
import com.pack.appfiles.repositories.ReservationRepo;

@Service
public class ReservationService {
    @Autowired
   private ReservationRepo reservationRepo;

    public void saveReservation(Reservation u){
        reservationRepo.save(u);
    }

    public void updateReservation(Reservation u){
            reservationRepo.save(u);
    }

    public void deleteReservation(Reservation u){
        reservationRepo.delete(u);
    }

    public Optional<Reservation> findReservationById(long id){
        return reservationRepo.findById(id);
    }

    public Reservation createReservationToday() {
        Reservation reservation = new Reservation(LocalDate.now());
        reservationRepo.save(reservation);
        return reservation;   
    }

    public Reservation createReservation(LocalDate d, User u, Workplace wp ) {
        Reservation reservation = new Reservation(d, u, wp);
        reservationRepo.save(reservation);
        return reservation;   
    }
}
