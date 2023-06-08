package com.pack.appfiles.models;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "buildings")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Building {
    @Id
    @SequenceGenerator(name = "buildings_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "buildings_id")
    int building_id;
    @Column(nullable = false)
    String city;
    @Column(unique = true)
    String address;
    @Column(nullable = true)
    String name ;
    @JsonIgnore
    @OneToMany(mappedBy = "building")
    List<Workplace> workplaces_list;

    public Building(String city, String address) {
        this.city = city;
        this.address = address;
        this.name = city + " building at " + address;
    }

    @Override
    public String toString() {
        return "Building [building_id=" + building_id + ", city=" + city + ", address=" + address + ", name=" + name
                + ", workplaces_list=" + workplaces_list + "]";
    }

}
