package com.example.exam.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ref;
    private float dimension;
    @OneToMany
    private Set<Personnel> personnel;
    @OneToOne(mappedBy = "zone")
    private Personnel personnelzone;
    @ManyToOne
    private Parking parking;
}
