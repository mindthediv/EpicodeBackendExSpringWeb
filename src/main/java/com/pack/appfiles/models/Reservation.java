package com.pack.appfiles.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Reservation {
    @Id
    @SequenceGenerator(name = "reservations_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservations_id")
    long reservation_id;
    @Column(nullable = false)
    LocalDate date;
    @JsonIgnore
    @ManyToOne
    User user;
    @JsonIgnore
    @ManyToOne
    Workplace workplace;
    

    public Reservation(LocalDate date, User user, Workplace workplace) {
        this.date = date;
        this.user = user;
        this.workplace = workplace;
    }

    public Reservation(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation [reservation_id=" + reservation_id + ", date=" + date +"]";
    }  

}
