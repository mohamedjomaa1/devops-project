package tn.devops.backend.services;

import tn.devops.backend.entities.Tarif;


import java.util.Set;

public interface ITarifService {

    Tarif addTarif(Tarif tarif);
    void deleteTarif(int id);
    Tarif getTarif(int id);
    Set<Tarif> getTarifs();
    Tarif updateTarif(int id,Tarif tarif);
}
