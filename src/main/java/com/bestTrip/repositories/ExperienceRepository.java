package com.bestTrip.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bestTrip.entities.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long>{

}
