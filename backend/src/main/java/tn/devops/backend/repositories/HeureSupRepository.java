package tn.devops.backend.repositories;

import tn.devops.backend.entities.HeureSup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeureSupRepository extends JpaRepository<HeureSup, Integer>{
}
