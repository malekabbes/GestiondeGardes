package com.example.exam.services.Personnel;

import com.example.exam.Repositories.PersonnelRepository;
import com.example.exam.Repositories.ZoneRepository;
import com.example.exam.entities.Parking;
import com.example.exam.entities.Personnel;
import com.example.exam.entities.Zone;
import com.example.exam.generic.ImplementationGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ImpPersonnel implements IntPersonnel{
    @Autowired
    PersonnelRepository repo;
    @Autowired
    ZoneRepository zrepo;

    @Override
    public Personnel ajouterPersonnel(Personnel personnel) {
        return repo.save(personnel);
    }
    public void affecterPersonnelZone(int idzone,int idGarde){
        Zone zone=zrepo.findById(idzone).orElse(null);
        Personnel garde=repo.findById(idGarde).orElse(null);
        zone.setPersonnel(Collections.singleton(garde));
        zrepo.save(zone);
    }
    public List<Personnel> getAllPersonnelByParking(Parking parking){
        return  repo.findPersonnelByZoneParking(parking);
    }
    public Integer nombreGardeJour(String adresse){
        return repo.nombreGardejour(adresse);
    }
    public List<Personnel> getPersonalByDate(Date startDate, Date endDate){
       return repo.getPersonnelByDateDeRecrutementBetween(startDate,endDate);
    }
    @Scheduled(fixedRate = 30000)
    public void getNbrGardesByZone(){
        List<Zone> list =zrepo.findAll();
        String data="";
        for (Zone z : list) {
            data = "Zone :"+repo.countPersonnelByZone(z);
        }
        }
}
