package com.pack.appfiles.security.models;

import java.util.HashSet;
import java.util.Set;

import com.pack.appfiles.security.enumerates.UserRole;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    // Aggiungi questa annotazione per permettere la join
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

}
