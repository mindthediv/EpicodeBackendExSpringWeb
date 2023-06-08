package com.pack.appfiles.models;

import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @SequenceGenerator(name = "users_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id")
    long user_id ;
    @Column(unique = true, nullable = false)
    String username;
    @Column(nullable = false)
    String full_name;
    @Column(unique = true, nullable = false)
    String email;
    @OneToMany(mappedBy = "user")
    List<Reservation> user_reservations;


    public User(String username, String full_name, String email) {
        this.username = username;
        this.full_name = full_name;
        this.email = email;
    }
}