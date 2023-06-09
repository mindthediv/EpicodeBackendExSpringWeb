package com.pack.appfiles.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "workplaces")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Workplace {
    @Id
    @SequenceGenerator(name = "workplaces_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workplaces_id")
    long workplace_id;
    String description;
    public enum type {PRIVATE,OPENSPACE,MEETING_ROOM} ; 
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    type type;
    @Column(nullable = true)
    int max_capacity;
    @ManyToOne(cascade = CascadeType.MERGE)
    Building building;
    @OneToMany(mappedBy = "workplace", cascade = CascadeType.MERGE)
    List<Reservation> workplace_reservations;
    
    public Workplace(String description,type type, int max_capacity, Building building) {
        this.description = description;
        this.max_capacity = max_capacity;
        this.building = building;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Workplace [workplace_id=" + workplace_id + ", description=" + description + ", type=" + type
                + ", max_capacity=" + max_capacity + ", building=" + building + ", workplace_reservations="
                + workplace_reservations + "]";
    }
    
}
