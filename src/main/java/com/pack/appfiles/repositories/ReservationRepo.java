package com.pack.appfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pack.appfiles.models.Reservation;


public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    
}