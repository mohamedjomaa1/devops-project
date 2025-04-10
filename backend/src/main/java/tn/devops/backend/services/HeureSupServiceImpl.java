package tn.devops.backend.services;


import tn.devops.backend.entities.Employe;
import tn.devops.backend.entities.HeureSup;
import tn.devops.backend.repositories.EmployeRepository;
import tn.devops.backend.repositories.HeureSupRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class HeureSupServiceImpl implements IHeureSupService{

    @Autowired
    private HeureSupRepository heureSupRepository;
    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public HeureSup addHeureSup(HeureSup hs) {
        return heureSupRepository.save(hs);
    }

    @Override
    public HeureSup updateHeureSup(int id, HeureSup hs) {
        return heureSupRepository.findById(id).isPresent() ? heureSupRepository.save(hs) : null;
    }

    @Override
    public void deleteHeureSup(int id) {
        heureSupRepository.deleteById(id);
    }

    @Override
    public HeureSup getHeureSup(int id) {
        return heureSupRepository.findById(id).isPresent() ? heureSupRepository.findById(id).get() : null;
    }

    @Override
    public Set<HeureSup> getHeureSups() {
        return new HashSet<>(heureSupRepository.findAll());
    }

    @Override
    public HeureSup affectEmployeById(int id, HeureSup hs) {
        Set<HeureSup> hss = new HashSet<>(heureSupRepository.findAll());
        Employe e=employeRepository.findById(id).isPresent() ? employeRepository.findById(id).get() : null;
        if(e==null){
            throw new RuntimeException("no employment available");
        }else{
            hs.setEmploye(e);
            e.setHeures_sup(hss);
        }
        employeRepository.save(e);
        return heureSupRepository.save(hs);
    }
}
