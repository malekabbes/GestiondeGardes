package com.example.exam.controllers;

import com.example.exam.entities.Parking;
import com.example.exam.entities.Personnel;
import com.example.exam.services.Parking.ImpParking;
import com.example.exam.services.Personnel.ImpPersonnel;
import com.example.exam.services.zone.ImpZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/parking")
public class ParkingController {
    @Autowired
    ImpParking servicep;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void AjouterParking(@RequestBody Parking p) throws Exception {
        servicep.ajoutParkingetZones(p);
    }
}
