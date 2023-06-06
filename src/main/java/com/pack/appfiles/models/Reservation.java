package com.pack.appfiles.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reservation {
    @Id
    @SequenceGenerator(name = "bookings_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookings_id")
    long booking_id;
    @Column(nullable = false)
    LocalDate date;
    // @ManyToOne
    // User user;
    // @OneToOne
    // Workplace workplace;
    
    public Reservation(LocalDate date) {
        this.date = date;
    }

}
