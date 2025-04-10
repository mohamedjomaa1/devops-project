package tn.devops.backend.repositories;

import tn.devops.backend.entities.Tarif;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifRepository extends JpaRepository<Tarif, Integer>{
}
