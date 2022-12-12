package com.example.exam.Repositories;

import com.example.exam.entities.Parking;
import com.example.exam.entities.Personnel;
import com.example.exam.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
List<Personnel> findPersonnelByZoneParking(Parking parking);
@Query(value = "SELECT COUNT(p) FROM Personnel p WHERE p.poste='GARDE_JOUR' AND p.zone.parking.adresse=?1")
Integer nombreGardejour(String adresse);

List<Personnel> getPersonnelByDateDeRecrutementBetween(Date startDate, Date endDate);

Integer countPersonnelByZone(Zone zone);

}