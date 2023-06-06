package com.pack.appfiles.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "workplaces")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Workplace {
    @Id
    @SequenceGenerator(name = "workplaces_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workplaces_id")
    long workplace_id;
    String description;
    public enum type {PRIVATE,OPENSPACE,MEETING_ROOM} ; 
    @Enumerated(EnumType.STRING)
    type type;
    @Column(nullable = true)
    int max_capacity;
    // @ManyToOne
    // Building building;
    public Workplace(String description, com.pack.appfiles.models.Workplace.type type, int max_capacity) {
        this.description = description;
        this.type = type;
        this.max_capacity = max_capacity;
    }
    
}