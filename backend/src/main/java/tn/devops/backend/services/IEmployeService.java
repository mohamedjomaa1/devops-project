package tn.devops.backend.services;

import tn.devops.backend.entities.Employe;


import java.util.Set;

public interface IEmployeService {

    Employe addEmploye(Employe employe);
    Employe updateEmploye(int id,Employe employe);
    void deleteEmploye(int id);
    Employe getEmploye(int id);
    Set<Employe> getEmployes();

}
