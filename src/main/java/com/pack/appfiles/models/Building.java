package com.pack.appfiles.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "offices")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Building {
    @Id
    @SequenceGenerator(name = "offices_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "offices_id")
    long office_id;
    @Column(nullable = false)
    String city;
    @Column(unique = true)
    String address;
    @Column(nullable = true)
    String name ;
    // @OneToMany(mappedBy = "workplace_id")
    // List<Workplace> workplaces;

    public Building(String city, String address) {
        this.city = city;
        this.address = address;
        this.name = city + " building at " + address;
    }
}
