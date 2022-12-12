package com.example.exam.Repositories;

import com.example.exam.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Integer> {
}