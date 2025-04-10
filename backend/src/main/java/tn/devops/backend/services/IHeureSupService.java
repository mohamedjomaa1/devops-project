package tn.devops.backend.services;

import tn.devops.backend.entities.HeureSup;


import java.util.Set;

public interface IHeureSupService {

    HeureSup addHeureSup(HeureSup hs);
    HeureSup updateHeureSup(int id,HeureSup hs);
    void deleteHeureSup(int id);
    HeureSup getHeureSup(int id);
    Set<HeureSup> getHeureSups();
    HeureSup affectEmployeById(int id, HeureSup hs);
}
