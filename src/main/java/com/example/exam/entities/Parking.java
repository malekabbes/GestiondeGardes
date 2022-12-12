package com.example.exam.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String designation;
    private String adresse;
    private int capacite;
    @OneToMany(mappedBy = "parking",cascade = CascadeType.PERSIST)
    private List<Zone> Zones;
}
