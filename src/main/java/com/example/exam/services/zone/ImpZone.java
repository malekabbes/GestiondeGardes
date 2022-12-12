package com.example.exam.services.zone;

import com.example.exam.Repositories.PersonnelRepository;
import com.example.exam.Repositories.ZoneRepository;
import com.example.exam.entities.Parking;
import com.example.exam.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ImpZone implements IntZone {
    @Autowired
    ZoneRepository repo;


}
