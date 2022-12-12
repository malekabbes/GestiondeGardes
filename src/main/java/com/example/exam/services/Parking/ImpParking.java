package com.example.exam.services.Parking;

import com.example.exam.Repositories.ParkingRepository;
import com.example.exam.Repositories.PersonnelRepository;
import com.example.exam.entities.Parking;
import com.example.exam.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ImpParking implements IntParking {
    @Autowired
    ParkingRepository repo;

    @Override
    @Transactional
    public void ajoutParkingetZones(Parking parking) {
        repo.save(parking);
    }
}
