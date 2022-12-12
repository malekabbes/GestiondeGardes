package com.example.exam.controllers;

import com.example.exam.entities.Parking;
import com.example.exam.entities.Personnel;
import com.example.exam.services.Personnel.ImpPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/personnel")
public class PersonnelController {
    @Autowired
    ImpPersonnel servicep;
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Personnel AjouterPersonnel(@RequestBody Personnel p) throws Exception {
        return servicep.ajouterPersonnel(p);
    }
    @RequestMapping(value = "/affect/{idz}/{idg}",method = RequestMethod.PUT)
    public void affecterPersonnelZone(@PathVariable Integer idz,@PathVariable Integer idg){
         servicep.affecterPersonnelZone(idz,idg);
    }
    @RequestMapping(value = "/all/{parking}",method = RequestMethod.GET)

    public List<Personnel> FindPersonnelByParking(@RequestBody Parking parking) throws Exception{
        try {
            return (List<Personnel>) servicep.getAllPersonnelByParking(parking);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/nbrgarde/{adresse}",method = RequestMethod.GET)

    public Integer nombreGardejour(@PathVariable String adresse) throws Exception{
        try {
            return servicep.nombreGardeJour(adresse);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
